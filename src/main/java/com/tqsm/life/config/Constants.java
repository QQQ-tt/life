package com.tqsm.life.config;

/**
 * <p></p>
 *
 * @author: xnd
 * @date: 2023/11/08 15:58
 **/
public class Constants {

    /**
     * 启用状态和未启用状态
     */
    public static final Integer ENABLE = 0;
    public static final Integer DISABLE = 1;

    /**
     * 异常提醒类型
     * 1 心率
     * 2 呼吸
     * 3 收缩压
     * 4 舒张压
     */
    public static final Integer HR = 1;
    public static final Integer BR = 2;
    public static final Integer SBP = 3;
    public static final Integer DBP = 4;


    /**
     * 删除状态
     * 1 已删除
     * 0 未删除
     */
    public static final Integer IS_DELETED = 1;
    public static final Integer UNDELETED = 0;

    /**
     * 测试连接
     * 1 有人
     * 0 无人
     */
    public static final Integer HAVE_PER = 1;
    public static final Integer NO_HAVE_PER = 0;

    /**
     * 异常查询类型
     * 1 历史
     * 2 详情
     */
    public static final Integer TABLE_HIS = 1;
    public static final Integer TABLE_NOW = 2;

}
