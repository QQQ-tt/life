package com.tqsm.life.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tqsm.life.config.BaseEntity;
import lombok.*;

/**
 * <p>
 * 设备患者关联表
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
@TableName("device_user")
public class DeviceUser extends BaseEntity {

    /**
     * 设备id
     */
    @TableField("device_id")
    private Integer deviceId;

    /**
     * 患者id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 历史记录
     */
    @TableField("is_his")
    private Boolean isHis;
}
