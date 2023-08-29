package com.tqsm.life.pojo.life.result.bp.pub.figure;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xnd
 * @since 2023/8/29 15:42
 */
@Data
public class Br {
    /**
     * ts: 生成该信息的时间戳
     */
    private String ts;

    /**
     * brNum：10s 呼吸波形点个数
     */
    private Integer brNum;

    /**
     * 10s 的全部呼吸波形点
     */
    private BigDecimal[] brFigure;
}
