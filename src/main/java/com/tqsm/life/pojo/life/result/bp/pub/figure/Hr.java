package com.tqsm.life.pojo.life.result.bp.pub.figure;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xnd
 * @since 2023/8/29 16:21
 */
@Data
public class Hr {

    /**
     * bcgNum：2 秒 bcg 波形点总数，
     */
    private Integer bcgNum;

    /**
     * ：bcg 波形点
     */
    private BigDecimal[] bcgFigure;

    /**
     * echNum: 2 秒 ecg 波形点个
     */
    private Integer ecgNum;

    /**
     * ecg 波形点
     */
    private BigDecimal[] ecgFigure;
}
