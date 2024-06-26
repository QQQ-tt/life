package com.tqsm.life.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tqsm.life.config.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 警报参数设置表
 * </p>
 *
 * @author xnd
 * @since 2023-11-01
 */
@Getter
@Setter
@TableName("alarm_setting")
public class AlarmSetting extends BaseEntity {

    /**
     * 设备id
     */
    @TableField("device_id")
    private Integer deviceId;

    /**
     * 心率左区间
     */
    @TableField("hr_left")
    private Integer hrLeft;

    /**
     * 心率右区间
     */
    @TableField("hr_right")
    private Integer hrRight;

    /**
     * 呼吸左区间
     */
    @TableField("br_left")
    private Integer brLeft;

    /**
     * 呼吸右区间
     */
    @TableField("br_right")
    private Integer brRight;

    /**
     * 收缩压左区间 值
     */
    @TableField("sbp_left")
    private Integer sbpLeft;

    /**
     * 收缩压右区间 值
     */
    @TableField("sbp_right")
    private Integer sbpRight;

    /**
     * 舒张压左区间 值
     */
    @TableField("dbp_left")
    private Integer dbpLeft;

    /**
     * 舒张压右区间 值
     */
    @TableField("dbp_right")
    private Integer dbpRight;

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

    /**
     * 弹窗提示时长（s）
     */
    @TableField("tims")
    private Integer tims;

    /**
     * 开启：0 ,关闭：1
     */
    @TableField("switches")
    private Integer switches;
}
