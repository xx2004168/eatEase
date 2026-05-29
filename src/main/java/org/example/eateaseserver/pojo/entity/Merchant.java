package org.example.eateaseserver.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家表;
 * @author : xuxin
 * @date : 2026-5-27
 */
@Schema(description = "商家表")
@Table(name="merchant")
@Data
public class Merchant implements Serializable,Cloneable{
    /** 商家ID */
    @Id
    @GeneratedValue
    @Schema(description = "商家ID")
    private Long id ;
    /** 所属食堂ID */
    @Schema(description = "所属食堂ID")
    private Long canteenId ;
    /** 商家名称 */
    @Schema(description = "商家名称")
    private String name ;
    /** 登录账号 */
    @Schema(description = "登录账号")
    private String username ;
    /** 登录密码（加密） */
    @Schema(description = "登录密码（加密）")
    private String password ;
    /** 联系电话 */
    @Schema(description = "联系电话")
    private String phone ;
    /** 营业状态：1营业中，0休息 */
    @Schema(description = "营业状态：1营业中，0休息")
    private Integer isOpen ;
    /** 注册时间 */
    @Schema(description = "注册时间")
    private Date createTime ;
    /** 商家图片URL */
    @Schema(description = "商家图片URL")
    private String imgUrl;

}
