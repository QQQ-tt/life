package com.tqsm.life.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tqsm.life.config.PageDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xnd
 * @since 2023/11/13 9:41
 */
@Data
public class AlarmMontiorLogDTO extends PageDTO {

    /**
     * 设备编号
     */
    @Schema(description = "设备编号")
    private String deviceCode;

    /**
     * 监测开始时间
     */
    @Schema(description = "监测开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    /**
     * 监测结束时间
     */
    @Schema(description = "监测结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;


    /**
     * 查询类型（心率，呼吸，收缩压，舒张压）
     */
    @Schema(description = "类型（心率，呼吸，收缩压，舒张压）")
    private String type;

    /**
     * 详情还是历史记录查询
     */
    @Schema(description = "1是查询历史，2是查询实时详情")
    private Integer table;

}
