package org.example.eateaseserver.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表;
 * @author : xuxin
 * @date : 2026-5-27
 */
@Schema(description = "订单表")
@Table(name="orders")
@Data
public class Orders implements Serializable,Cloneable{
    /** 订单ID */
    @Id
    @GeneratedValue
    @Schema(description = "订单ID")
    private Long id ;
    /** 用户ID */
    @Schema(description = "用户ID")
    private Long userId ;
    /** 商家ID */
    @Schema(description = "商家ID")
    private Long merchantId ;
    /** 订单号（唯一） */
    @Schema(description = "订单号（唯一）")
    private String orderNo ;
    /** 订单明细，JSON格式：[{"dishId":1,"name":"红烧肉","quantity":2,"price":12}] */
    @Schema(description = "订单明细，JSON格式")
    private String items ;
    /** 总金额 */
    @Schema(description = "总金额")
    private Double totalPrice ;
    /** 就餐方式：0堂食，1外带 */
    @Schema(description = "就餐方式：0堂食，1外带")
    private Integer diningType ;
    /** 堂食时同行人数 */
    @Schema(description = "堂食时同行人数")
    private Integer groupSize ;
    /** 占用的桌子数量（由group_size和seats_per_table计算） */
    @Schema(description = "占用的桌子数量（由group_size和seats_per_table计算）")
    private Integer needTables ;
    /** 期望取餐时间 */
    @Schema(description = "期望取餐时间")
    private Date expectedTime ;
    /** 状态：0待接单，1制作中，2可取餐，3已完成，4已取消 */
    @Schema(description = "状态：0待接单，1制作中，2可取餐，3已完成，4已取消")
    private Integer status ;
    /** 下单时间 */
    @Schema(description = "下单时间")
    private Date orderTime ;
    /** 实际取餐时间（完成时记录） */
    @Schema(description = "实际取餐时间（完成时记录）")
    private Date finishTime ;
}