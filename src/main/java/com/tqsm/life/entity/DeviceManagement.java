package com.tqsm.life.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tqsm.life.config.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 设备管理
 * </p>
 *
 * @author qtx
 * @since 2023-08-31
 */
@Getter
@Setter
@TableName("device_management")
public class DeviceManagement extends BaseEntity {

    /**
     * 设备名称
     */
    @TableField("device_name")
    private String deviceName;

    /**
     * 设备编号
     */
    @TableField("device_code")
    private String deviceCode;

    /**
     * 用户id
     */
    @TableField("user_management_id")
    private Integer userManagementId;
}
