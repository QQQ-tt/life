package com.tqsm.life.pojo.life.result.fatigue.pub;

import lombok.Data;

/**
 * @author xnd
 * @since 2023/8/29 16:36
 */
@Data
public class ResultsFatiguePub {

    /**
     * 状态信息。其中 0 表示该次请求未得到有效数据。1 表示返回的数据有效。-1
     * 表示服务器处理出现异常
     */
    private Integer code;

    /**
     * state: 其中 1 有人，0 无人
     */
    private Integer state;

    /**
     * 疲劳度分数
     */
    private Integer score;
}
