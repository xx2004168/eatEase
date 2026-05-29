package org.example.eateaseserver.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生用户表;
 * @author : xuxin
 * @date : 2026-5-27
 */
@Schema(description = "学生用户表")
@Table(name="user")
@Data
public class User implements Serializable,Cloneable{
    /** 用户ID */
    @Id
    @GeneratedValue
    @Schema(description = "用户ID")
    private Long id ;
    /** 用户名 */
    @Schema(description = "用户名")
    private String username ;
    /** 密码（加密） */
    @Schema(description = "密码（加密）")
    private String password ;
    /** 积分 */
    @Schema(description = "积分")
    private Integer points ;
    /** 注册时间 */
    @Schema(description = "注册时间")
    private Date createTime ;
    /** 姓名 */
    @Schema(description = "姓名")
    private String name;
    /** 手机号 */
    @Schema(description = "手机号")
    private String phone;

    /** 头像URL */
    @Schema(description = "头像URL")
    private String imgUrl;

}