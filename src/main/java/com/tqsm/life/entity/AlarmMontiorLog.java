package com.tqsm.life.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tqsm.life.config.BaseEntity;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 警报异常记录表
 * </p>
 *
 * @author xnd
 * @since 2023-11-03
 */
@Getter
@Setter
@TableName("alarm_montior_log")
public class AlarmMontiorLog extends BaseEntity {

    /**
     * 设备编号
     */
    @TableField("device_code")
    private String deviceCode;

    /**
     * 监测时间
     */
    @TableField("monitoring_time")
    private LocalDateTime monitoringTime;

    /**
     * 异常项目
     */
    @TableField("exception_item")
    private String exceptionItem;

    /**
     * 异常值
     */
    @TableField("exception_value")
    private Integer exceptionValue;

    /**
     * 参考值区间
     */
    @TableField("reference_interval")
    private String referenceInterval;
}
