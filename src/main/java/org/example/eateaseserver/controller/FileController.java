package org.example.eateaseserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.example.eateaseserver.pojo.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@Tag(name = "文件模块", description = "文件上传下载接口")
public class FileController {

    @Value("${file.upload-dir:uploads}")
    private String uploadDir;

    @Value("${server.port:8080}")
    private String serverPort;

    @PostMapping("/upload")
    @Operation(summary = "文件上传接口")
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return CommonResult.error(400, "文件不能为空");
        }

        String originalFilename = file.getOriginalFilename();
        String extension = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }

        String newFileName = UUID.randomUUID().toString().replace("-", "") + extension;
        File dest = new File(uploadDir + File.separator + newFileName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            String url = "http://localhost:" + serverPort + "/file/download/" + newFileName;
            return CommonResult.success(url, "上传成功");
        } catch (IOException e) {
            return CommonResult.error(500, "上传失败: " + e.getMessage());
        }
    }

    @GetMapping("/download/{filename}")
    @Operation(summary = "文件下载接口")
    public void download(@PathVariable String filename, jakarta.servlet.http.HttpServletResponse response) {
        File file = new File(uploadDir + File.separator + filename);
        if (!file.exists()) {
            response.setStatus(404);
            return;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);
        try (java.io.InputStream in = new java.io.FileInputStream(file)) {
            in.transferTo(response.getOutputStream());
        } catch (IOException e) {
            response.setStatus(500);
        }
    }
}
