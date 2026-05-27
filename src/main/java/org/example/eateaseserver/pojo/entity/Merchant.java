package org.example.eateaseserver.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 商家表;
 * @author : xuxin
 * @date : 2026-5-27
 */
@Schema(description = "商家表")
@Table(name="merchant")
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

    /** 商家ID */
    public Long getId(){
        return this.id;
    }
    /** 商家ID */
    public void setId(Long id){
        this.id=id;
    }
    /** 所属食堂ID */
    public Long getCanteenId(){
        return this.canteenId;
    }
    /** 所属食堂ID */
    public void setCanteenId(Long canteenId){
        this.canteenId=canteenId;
    }
    /** 商家名称 */
    public String getName(){
        return this.name;
    }
    /** 商家名称 */
    public void setName(String name){
        this.name=name;
    }
    /** 登录账号 */
    public String getUsername(){
        return this.username;
    }
    /** 登录账号 */
    public void setUsername(String username){
        this.username=username;
    }
    /** 登录密码（加密） */
    public String getPassword(){
        return this.password;
    }
    /** 登录密码（加密） */
    public void setPassword(String password){
        this.password=password;
    }
    /** 联系电话 */
    public String getPhone(){
        return this.phone;
    }
    /** 联系电话 */
    public void setPhone(String phone){
        this.phone=phone;
    }
    /** 营业状态：1营业中，0休息 */
    public Integer getIsOpen(){
        return this.isOpen;
    }
    /** 营业状态：1营业中，0休息 */
    public void setIsOpen(Integer isOpen){
        this.isOpen=isOpen;
    }
}
