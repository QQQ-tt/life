CREATE TABLE `device_heartbeat`
(
    `id`          int                                                          NOT NULL AUTO_INCREMENT,
    `device_id`   int                                                          NOT NULL COMMENT '设备id',
    `person`      bit                                                          NULL COMMENT '是否有人',
    `online`      bit                                                          NULL COMMENT '是否在线',
    `create_by`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建人',
    `create_on`   datetime(0)                                                  NOT NULL COMMENT '创建时间',
    `update_by`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT '编辑人',
    `update_on`   datetime(0)                                                  NULL     DEFAULT NULL COMMENT '编辑时间',
    `delete_flag` bit(1)                                                       NOT NULL DEFAULT b'0' COMMENT '未删除：0 ,已删除：1',
    PRIMARY KEY (`id`)
) COMMENT = '设备心跳记录';