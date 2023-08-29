package com.tqsm.life.pojo.life.result.bp;

import lombok.Data;

/**
 * @author xnd
 * @since 2023/8/29 15:10
 */
@Data
public class Other {
    /**
     * pmrPower：主板电量，显示电池电量。
     */
    private Integer pmrPower;

    /**
     * isCharging: 是否在充电。
     */
    private Integer isCharging;

    /**
     * movingCount: 体动次数，1 分钟清空一次，单位 次/分钟
     */
    private Integer movingCount;

    /**
     * isSedentariness：久坐提醒
     */
    private Integer isSedentariness;
}
