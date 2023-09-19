package com.tqsm.life.pojo.life.result.bp.figure;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xnd
 * @since 2023/8/29 15:38
 */
@Data
public class Hr {
    /**
     * ts: 生成该信息的时间戳
     */
    private String ts;

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
