CREATE TABLE `device_user`
(
    `id`          int                                                          NOT NULL AUTO_INCREMENT,
    `device_id`   int                                                          NULL,
    `is_his`      bit                                                          NULL COMMENT '历史记录',
    `create_by`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建人',
    `create_on`   datetime(0)                                                  NOT NULL COMMENT '创建时间',
    `update_by`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT '编辑人',
    `update_on`   datetime(0)                                                  NULL     DEFAULT NULL COMMENT '编辑时间',
    `delete_flag` int                                                          NOT NULL DEFAULT 0 COMMENT '未删除：0 ,已删除：1',
    PRIMARY KEY (`id`)
);