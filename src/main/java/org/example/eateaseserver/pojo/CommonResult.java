package org.example.eateaseserver.pojo;

import lombok.Data;

@Data
public class CommonResult {
    private Integer code;
    private  String message;
    private Object data;
    public static CommonResult success(Object data) {
        CommonResult result = new CommonResult();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }
    public static CommonResult error(Integer code, String message) {
        CommonResult result = new CommonResult();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }
    public static CommonResult success(Object data, String message) {
        CommonResult result = new CommonResult();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    public static CommonResult error(String message) {
        return error(500, message);
    }
}
