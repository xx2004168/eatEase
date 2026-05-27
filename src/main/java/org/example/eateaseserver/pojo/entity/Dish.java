package org.example.eateaseserver.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * 菜品表;
 * @author : xuxin
 * @date : 2026-5-27
 */
@Schema(description = "菜品表")
@Table(name="dish")
public class Dish implements Serializable,Cloneable{
    /** 菜品ID */
    @Id
    @GeneratedValue
    @Schema(description = "菜品ID")
    private Long id ;
    /** 所属商家ID */
    @Schema(description = "所属商家ID")
    private Long merchantId ;
    /** 菜品名称 */
    @Schema(description = "菜品名称")
    private String name ;
    /** 价格（元） */
    @Schema(description = "价格（元）")
    private Double price ;
    /** 图片URL */
    @Schema(description = "图片URL")
    private String imageUrl ;
    /** 口味标签，逗号分隔，如"辣,荤,油炸" */
    @Schema(description = "口味标签，逗号分隔，如\"辣,荤,油炸\"")
    private String tags ;
    /** 当日点赞数（每日清零） */
    @Schema(description = "当日点赞数（每日清零）")
    private Integer likeCount ;
    /** 菜品所属日期 */
    @Schema(description = "菜品所属日期")
    private LocalDate date ;
    /** 当日库存，0表示不限量 */
    @Schema(description = "当日库存，0表示不限量")
    private Integer stock ;

    /** 菜品ID */
    public Long getId(){
        return this.id;
    }
    /** 菜品ID */
    public void setId(Long id){
        this.id=id;
    }
    /** 所属商家ID */
    public Long getMerchantId(){
        return this.merchantId;
    }
    /** 所属商家ID */
    public void setMerchantId(Long merchantId){
        this.merchantId=merchantId;
    }
    /** 菜品名称 */
    public String getName(){
        return this.name;
    }
    /** 菜品名称 */
    public void setName(String name){
        this.name=name;
    }
    /** 价格（元） */
    public Double getPrice(){
        return this.price;
    }
    /** 价格（元） */
    public void setPrice(Double price){
        this.price=price;
    }
    /** 图片URL */
    public String getImageUrl(){
        return this.imageUrl;
    }
    /** 图片URL */
    public void setImageUrl(String imageUrl){
        this.imageUrl=imageUrl;
    }
    /** 口味标签，逗号分隔，如“辣,荤,油炸” */
    public String getTags(){
        return this.tags;
    }
    /** 口味标签，逗号分隔，如“辣,荤,油炸” */
    public void setTags(String tags){
        this.tags=tags;
    }
    /** 当日点赞数（每日清零） */
    public Integer getLikeCount(){
        return this.likeCount;
    }
    /** 当日点赞数（每日清零） */
    public void setLikeCount(Integer likeCount){
        this.likeCount=likeCount;
    }
    /** 菜品所属日期 */
    public LocalDate getDate(){
        return this.date;
    }
    /** 菜品所属日期 */
    public void setDate(LocalDate date){
        this.date=date;
    }
    /** 当日库存，0表示不限量 */
    public Integer getStock(){
        return this.stock;
    }
    /** 当日库存，0表示不限量 */
    public void setStock(Integer stock){
        this.stock=stock;
    }
}