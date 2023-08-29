package com.tqsm.life.pojo.life.result.fatigue.pub.rhythm;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xnd
 * @since 2023/8/29 16:59
 */
@Data
public class ResultsFatiguePubRhythm {

    private Integer code;

    /**
     * ts: 生成该信息的时间戳
     */
    private String ts;

    /**
     * 节律图点个数。0 表示该次请求没有新的节律图点
     */
    private Integer len;

    /**
     * 节律图点，范围从 0.46~1.5
     */
    private BigDecimal[] buffer;

    private Integer state;


}
