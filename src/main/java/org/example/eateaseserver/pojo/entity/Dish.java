package org.example.eateaseserver.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

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
@Data
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
}