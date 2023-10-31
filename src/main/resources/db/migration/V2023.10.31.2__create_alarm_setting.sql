CREATE TABLE `alarm_setting`
(
    `id`          int                                                          NOT NULL COMMENT '主键',
    `hr_left`     int                                                          NOT NULL COMMENT '心率左区间',
    `hr_right`    int                                                          NOT NULL COMMENT '心率右区间',
    `br_left`     int                                                          NOT NULL COMMENT '呼吸左区间',
    `br_right`    int                                                          NOT NULL COMMENT '呼吸右区间',
    `sbp_left`    int                                                          NOT NULL COMMENT '收缩压左区间值',
    `sbp_right`   int                                                          NOT NULL COMMENT '收缩压右区间值',
    `dbp_left`    int                                                          NOT NULL COMMENT '舒张压左区间值',
    `dbp_right`   int                                                          NOT NULL COMMENT '舒张压右区间值',
    `tims`        int                                                          NOT NULL DEFAULT '0' COMMENT '弹窗提示时长（s）',
    `switch`      int                                                          NOT NULL DEFAULT '0' COMMENT '开启：0 ,关闭：1',
    `create_by`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建人',
    `create_on`   datetime                                                     NOT NULL COMMENT '创建时间',
    `update_by`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL COMMENT '编辑人',
    `update_on`   datetime                                                              DEFAULT NULL COMMENT '编辑时间',
    `delete_flag` int                                                          NOT NULL DEFAULT '0' COMMENT '未删除：0 ,已删除：1',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='警报参数设置表';