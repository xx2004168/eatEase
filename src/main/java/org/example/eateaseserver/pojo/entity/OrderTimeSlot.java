package org.example.eateaseserver.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

/**
 * 时段定义表（用于预设可预约时段）;
 * @author : xuxin
 * @date : 2026-5-27
 */
@Schema(description = "时段定义表（用于预设可预约时段）")
@Table(name="order_time_slot")
@Data
public class OrderTimeSlot implements Serializable,Cloneable{
    /**  */
    @Id
    @GeneratedValue
    @Schema(description = "ID")
    private Long id ;
    /** 食堂ID */
    @Schema(description = "食堂ID")
    private Long canteenId ;
    /** 开始时间 */
    @Schema(description = "开始时间")
    private LocalTime startTime ;
    /** 结束时间 */
    @Schema(description = "结束时间")
    private LocalTime endTime ;

}