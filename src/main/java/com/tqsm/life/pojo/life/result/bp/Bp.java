package com.tqsm.life.pojo.life.result.bp;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xnd
 * @since 2023/8/29 15:07
 */
@Data
public class Bp {
    /**
     * sbp: 收缩压，单位 mmHg，范围: 0-250
     */
    private Integer sbp;

    /**
     * dbp: 舒张压，单位 mmHg，范围: 0-250
     */
    private Integer dbp;

    /**
     * ts: 生成该信息的时间戳
     */
    private String ts;

    /**
     * sbpFigure：收缩压波形
     */
    private BigDecimal[] sbpFigure;

    /**
     * dbpFigure：舒张压波形
     */
    private BigDecimal[] dbpFigure;

}
