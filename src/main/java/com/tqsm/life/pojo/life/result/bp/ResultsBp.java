package com.tqsm.life.pojo.life.result.bp;

import lombok.Data;

/**
 * @author qtx
 * @since 2023/8/24
 */
@Data
public class ResultsBp {

    private String code;

    private Finger finger;

    private Result result;

    private Bp bp;

    private Other other;

    private Exception exception;
}
