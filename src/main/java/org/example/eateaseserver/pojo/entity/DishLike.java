package org.example.eateaseserver.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 菜品点赞表;
 * @author : xuxin
 * @date : 2026-5-27
 */
@Schema(description = "菜品点赞表")
@Table(name="dish_like")
public class DishLike implements Serializable,Cloneable{
    /** 点赞ID */
    @Id
    @GeneratedValue
    @Schema(description = "点赞ID")
    private Long id ;
    /** 用户ID */
    @Schema(description = "用户ID")
    private Long userId ;
    /** 菜品ID */
    @Schema(description = "菜品ID")
    private Long dishId ;
    /** 点赞时间 */
    @Schema(description = "点赞时间")
    private Date likeTime ;

    /** 点赞ID */
    public Long getId(){
        return this.id;
    }
    /** 点赞ID */
    public void setId(Long id){
        this.id=id;
    }
    /** 用户ID */
    public Long getUserId(){
        return this.userId;
    }
    /** 用户ID */
    public void setUserId(Long userId){
        this.userId=userId;
    }
    /** 菜品ID */
    public Long getDishId(){
        return this.dishId;
    }
    /** 菜品ID */
    public void setDishId(Long dishId){
        this.dishId=dishId;
    }
    /** 点赞时间 */
    public Date getLikeTime(){
        return this.likeTime;
    }
    /** 点赞时间 */
    public void setLikeTime(Date likeTime){
        this.likeTime=likeTime;
    }
}