package org.example.eateaseserver.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 食堂表;
 * @author : xuxin
 * @date : 2026-5-27
 */
@Schema(description = "食堂表")
@Table(name="canteen")
@Data
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
}
