package com.tqsm.life.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author xnd
 * @since 2023/10/26 9:38
 */
@Data
public class HistoricalBrExceptionVO {

    /**
     * br：呼吸值
     */
    private Integer br;

    /**
     * br_exception：呼吸异常。其中：1 异常，0 正常
     */
    private Integer br_exception;
}
