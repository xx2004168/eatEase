package org.example.eateaseserver.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
@Schema(description = "管理员表")
@TableName("admin")
public class Admin implements Serializable, Cloneable {
    @Schema(description = "管理员ID")
    @TableId
    private Long id;

    @Schema(description = "登录账号")
    @TableField("username")
    private String username;

    @Schema(description = "登录密码（加密）")
    @TableField("password")
    private String password;

    @Schema(description = "昵称")
    @TableField("name")
    private String name;

    @Schema(description = "创建时间")
    @TableField("create_time")
    private Date createTime;
}
