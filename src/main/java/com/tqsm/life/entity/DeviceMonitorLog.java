package com.tqsm.life.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tqsm.life.config.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 设备监测记录
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
@Getter
@Setter
@TableName("device_monitor_log")
public class DeviceMonitorLog extends BaseEntity {

    @TableField("device_user_id")
    private Integer deviceUserId;

    /**
     * 历史记录
     */
    @TableField("is_his")
    private Boolean isHis;
}
