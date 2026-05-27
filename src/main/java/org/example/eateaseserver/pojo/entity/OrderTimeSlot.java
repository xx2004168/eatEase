package org.example.eateaseserver.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
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

    /**  */
    public Long getId(){
        return this.id;
    }
    /**  */
    public void setId(Long id){
        this.id=id;
    }
    /** 食堂ID */
    public Long getCanteenId(){
        return this.canteenId;
    }
    /** 食堂ID */
    public void setCanteenId(Long canteenId){
        this.canteenId=canteenId;
    }
    /** 开始时间 */
    public LocalTime getStartTime(){
        return this.startTime;
    }
    /** 开始时间 */
    public void setStartTime(LocalTime startTime){
        this.startTime=startTime;
    }
    /** 结束时间 */
    public LocalTime getEndTime(){
        return this.endTime;
    }
    /** 结束时间 */
    public void setEndTime(LocalTime endTime){
        this.endTime=endTime;
    }
}