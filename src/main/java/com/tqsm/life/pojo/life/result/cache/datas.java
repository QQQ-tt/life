package com.tqsm.life.pojo.life.result.cache;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xnd
 * @since 2023/8/29 17:46
 */
@Data
public class datas {

    /**
     * ts: 生成该信息的时间戳
     */
    private String ts;

    /**
     * 有人/无人状态信息。其中：0 无人，1 有人
     */
    private Integer state;

    /**
     * hr：心率值
     */
    private Integer hr;

    /**
     * br：呼吸值
     */
    private Integer br;

    /**
     * sbp：收缩压
     */
    private Integer sbp;

    /**
     * dbp：舒张压
     */
    private Integer dbp;

    /**
     * moving_count：体动值。
     */
    private Integer movingCount;

    /**
     * br_exception：呼吸异常。其中：1 异常，0 正常
     */
    private Integer brException;

    /**
     * hr_exception：心率异常。其中：1 异常，0
     */
    private Integer hrException;

    /**
     * rhythm_points：节律图点，范围从 0.46~1.
     */
    private BigDecimal[] rhythmPoints;


}
