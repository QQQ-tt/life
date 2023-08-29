package com.tqsm.life.pojo.life.result.bp;

import lombok.Data;

/**
 * @author xnd
 * @since 2023/8/29 15:18
 */
@Data
public class Exception {
    /**
     * brException: 低通气警告，功能未稳定，可忽略
     */
    private Integer brException;

    /**
     * hrException: 心脏衰竭，功能未稳定，可忽略
     */
    private Integer hrException;

    /**
     * outRangeException: 超出测量范围
     */
    private Integer outRangeException;

    /**
     * moveException: 运动异常
     */
    private Integer moveException;

    /**
     * powerException: 电量过低
     */
    private Integer powerException;

    /**
     * sensorException: 传感器异常
     */
    private Integer sensorException;

    /**
     * resultException: 显示结果可能存在异常
     */
    private Integer resultException;

}
