CREATE TABLE `device_management`
(
    `id`                 int                                                          NOT NULL AUTO_INCREMENT,
    `device_name`        varchar(50)                                                  NOT NULL COMMENT '设备名称',
    `device_code`        varchar(50)                                                  NOT NULL COMMENT '设备编号',
    `user_management_id` int                                                          NULL COMMENT '用户id',
    `create_by`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建人',
    `create_on`          datetime(0)                                                  NOT NULL COMMENT '创建时间',
    `update_by`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT '编辑人',
    `update_on`          datetime(0)                                                  NULL     DEFAULT NULL COMMENT '编辑时间',
    `delete_flag`        bit                                                          NOT NULL DEFAULT 0 COMMENT '未删除：0 ,已删除：1',
    PRIMARY KEY (`id`)
) COMMENT = '设备管理';