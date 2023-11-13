package com.tqsm.life.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xnd
 * @since 2023/11/13 13:31
 */
@Data
public class AlarmMontiorLogPageVO {
    /**
     * 设备编号
     */
    @Schema(description = "设备编号")
    private String deviceCode;

    /**
     * 监测时间
     */
    @Schema(description = "监测时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime monitoringTime;

    /**
     * 异常项目
     */
    @Schema(description = "异常项目")
    private String exceptionItem;

    /**
     * 异常值
     */
    @Schema(description = "异常值")
    private Integer exceptionValue;

    /**
     * 参考值区间
     */
    @Schema(description = "参考值区间")
    private String referenceInterval;
}
