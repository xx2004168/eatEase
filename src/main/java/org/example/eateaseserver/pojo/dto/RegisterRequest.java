package org.example.eateaseserver.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "注册请求参数")
public class RegisterRequest {
    @Schema(description = "角色类型：user, merchant, admin")
    private String role;

    @Schema(description = "用户名（登录账号）")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "姓名/昵称")
    private String name;

    @Schema(description = "所属食堂ID（商家用）")
    private Long canteenId;

    @Schema(description = "联系电话")
    private String phone;
}
