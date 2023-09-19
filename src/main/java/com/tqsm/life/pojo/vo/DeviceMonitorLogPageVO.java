package com.tqsm.life.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xnd
 * @since 2023/9/7 11:04
 */
@Data
public class DeviceMonitorLogPageVO {

    @Schema(description = "监测开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createOn;

    @Schema(description = "监测结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateOn;

    @Schema(description = "监测时长")
    private String listening;
}
