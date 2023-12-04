package com.tqsm.life.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author xnd
 * @since 2023/10/26 9:38
 */
@Data
public class HistoricalHrExceptionVO {

    /**
     * hr：心率值
     */
    private Integer hr;

    /**
     * hr_exception：心率异常。其中：1 异常，0 正常
     */
    private Integer hrException;
}
