package com.tqsm.life.pojo.life.result.fatigue.pub;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xnd
 * @since 2023/8/29 17:16
 */
@Data
public class PubSummary {

    private  Integer code;

    /**
     * ts: 生成该信息的时间戳
     */
    private String ts;

    private Integer state;

    /**
     * 波形点总数，每分钟一个点，最大为 65，即保存最近 65 分钟的
     */
    private Integer len;

    /**
     * 心率值波形，每分钟一个点，-1 表示该分钟未能计算出有效心率值。最多
     * 保存 65 分钟的值，当超过 65 分钟后，删除 buffer 头部最开始的值，将新值插入到 buffer
     * 尾部。范围：0~140
     */
    private BigDecimal[] bmpBuffer;

    /**
     * 疲劳度值波形，同上。范围：0~5。
     */
    private BigDecimal[] fatigueBuffer;
}
