CREATE TABLE `alarm_montior_log`
(
    `id`              int                                                          NOT NULL AUTO_INCREMENT,
    `monitoring_time` datetime                                                     NOT NULL COMMENT '监测时间',
    `exception _item` varchar(50)                                                  NOT NULL COMMENT '异常项目',
    `exception_value` int                                                          NOT NULL COMMENT '异常值',
    `create_by`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建人',
    `create_on`       datetime                                                     NOT NULL COMMENT '创建时间',
    `update_by`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL COMMENT '编辑人',
    `update_on`       datetime                                                              DEFAULT NULL COMMENT '编辑时间',
    `delete_flag`     int                                                          NOT NULL DEFAULT '0' COMMENT '未删除：0 ,已删除：1',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='警报异常记录表';