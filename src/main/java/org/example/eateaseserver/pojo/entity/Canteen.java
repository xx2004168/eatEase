package org.example.eateaseserver.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 食堂表;
 * @author : xuxin
 * @date : 2026-5-27
 */
@Schema(description = "食堂表")
@Table(name="canteen")
public class Canteen implements Serializable,Cloneable{
    /** 食堂ID */
    @Id
    @GeneratedValue
    @Schema(description = "食堂ID")
    private Long id ;
    /** 食堂名称 */
    @Schema(description = "食堂名称")
    private String name ;
    /** 总桌数 */
    @Schema(description = "总桌数")
    private Integer totalTables ;
    /** 每桌容纳人数 */
    @Schema(description = "每桌容纳人数")
    private Integer seatsPerTable ;
    /** 营业时段，如"10:30-13:30,16:30-19:30" */
    @Schema(description = "营业时段，如\"10:30-13:30,16:30-19:30\"")
    private String openHours ;
    /** 位置描述 */
    @Schema(description = "位置描述")
    private String location ;

    /** 食堂ID */
    public Long getId(){
        return this.id;
    }
    /** 食堂ID */
    public void setId(Long id){
        this.id=id;
    }
    /** 食堂名称 */
    public String getName(){
        return this.name;
    }
    /** 食堂名称 */
    public void setName(String name){
        this.name=name;
    }
    /** 总桌数 */
    public Integer getTotalTables(){
        return this.totalTables;
    }
    /** 总桌数 */
    public void setTotalTables(Integer totalTables){
        this.totalTables=totalTables;
    }
    /** 每桌容纳人数 */
    public Integer getSeatsPerTable(){
        return this.seatsPerTable;
    }
    /** 每桌容纳人数 */
    public void setSeatsPerTable(Integer seatsPerTable){
        this.seatsPerTable=seatsPerTable;
    }
    /** 营业时段，如“10:30-13:30,16:30-19:30” */
    public String getOpenHours(){
        return this.openHours;
    }
    /** 营业时段，如“10:30-13:30,16:30-19:30” */
    public void setOpenHours(String openHours){
        this.openHours=openHours;
    }
    /** 位置描述 */
    public String getLocation(){
        return this.location;
    }
    /** 位置描述 */
    public void setLocation(String location){
        this.location=location;
    }
}
