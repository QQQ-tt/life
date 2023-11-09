package com.tqsm.life.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/11/9 9:45
 */
@Data
public class DeviceAlertQueryVO {

    /**
     * 设备id
     */
    @TableField("device_id")
    private Integer deviceId;

    /**
     * 血压预警开关（0:开启，1:关闭）
     */
    @TableField("bp_alert")
    private Integer bpAlert;

    /**
     * 心电图预警开关（0:开启,1:关闭）
     */
    @TableField("hr_alert")
    private Integer hrAlert;

    /**
     * 呼吸预警开关(0:开启，1:关闭)
     */
    @TableField("br_alert")
    private Integer brAlert;
}
