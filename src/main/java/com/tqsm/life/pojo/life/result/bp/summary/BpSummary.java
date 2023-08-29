package com.tqsm.life.pojo.life.result.bp.summary;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xnd
 * @since 2023/8/29 16:07
 */
@Data
public class BpSummary {
    /**
     * dbp: 舒张压统计点，1 分钟一个点。
     */
    private BigDecimal[] dbp;

    /**
     * sbp: 收缩压统计点，1 分钟一个点。
     */
    private BigDecimal[] sbp;

    /**
     * bpTs: 生成血压统计的时间戳
     */
    private String bpTs;
}
