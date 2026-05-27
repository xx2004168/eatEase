package org.example.eateaseserver.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生用户表;
 * @author : xuxin
 * @date : 2026-5-27
 */
@Schema(description = "学生用户表")
@Table(name="user")
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
    /** 口味偏好标签，逗号分隔，如"辣,荤" */
    @Schema(description = "口味偏好标签，逗号分隔，如\"辣,荤\"")
    private String preferenceTags ;
    /** 积分 */
    @Schema(description = "积分")
    private Integer points ;
    /** 注册时间 */
    @Schema(description = "注册时间")
    private Date createTime ;

    /** 用户ID */
    public Long getId(){
        return this.id;
    }
    /** 用户ID */
    public void setId(Long id){
        this.id=id;
    }
    /** 用户名 */
    public String getUsername(){
        return this.username;
    }
    /** 用户名 */
    public void setUsername(String username){
        this.username=username;
    }
    /** 密码（加密） */
    public String getPassword(){
        return this.password;
    }
    /** 密码（加密） */
    public void setPassword(String password){
        this.password=password;
    }
    /** 口味偏好标签，逗号分隔，如“辣,荤” */
    public String getPreferenceTags(){
        return this.preferenceTags;
    }
    /** 口味偏好标签，逗号分隔，如“辣,荤” */
    public void setPreferenceTags(String preferenceTags){
        this.preferenceTags=preferenceTags;
    }
    /** 积分 */
    public Integer getPoints(){
        return this.points;
    }
    /** 积分 */
    public void setPoints(Integer points){
        this.points=points;
    }
    /** 注册时间 */
    public Date getCreateTime(){
        return this.createTime;
    }
    /** 注册时间 */
    public void setCreateTime(Date createTime){
        this.createTime=createTime;
    }
}