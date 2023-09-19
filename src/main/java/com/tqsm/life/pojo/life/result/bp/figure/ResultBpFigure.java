package com.tqsm.life.pojo.life.result.bp.figure;

import lombok.Data;

/**
 * @author xnd
 * @since 2023/8/29 15:33
 */
@Data
public class ResultBpFigure {

    private Integer code;

    private Integer state;

    private Hr hr;

    private Br br;

    private Other other;
}
