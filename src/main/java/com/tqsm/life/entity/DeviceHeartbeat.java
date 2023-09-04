package com.tqsm.life.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tqsm.life.config.BaseEntity;
import lombok.*;

/**
 * <p>
 * 设备心跳记录
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("device_heartbeat")
public class DeviceHeartbeat extends BaseEntity {

    /**
     * 设备id
     */
    @TableField("device_id")
    private Integer deviceId;

    /**
     * 是否有人
     */
    @TableField("person")
    private Boolean person;

    /**
     * 是否在线
     */
    @TableField("online")
    private Boolean online;
}
