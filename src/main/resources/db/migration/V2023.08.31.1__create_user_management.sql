CREATE TABLE `user_management`
(
    `id`          int         NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`        varchar(50) NOT NULL COMMENT '姓名',
    `sex`         int         NOT NULL COMMENT '男：1 女：0',
    `id_card`     varchar(19) NOT NULL COMMENT '身份证号',
    `tel`         varchar(13) NOT NULL COMMENT '手机号',
    `create_by`   varchar(50) NOT NULL COMMENT '创建人',
    `create_on`   datetime    NOT NULL COMMENT '创建时间',
    `update_by`   varchar(50) DEFAULT NULL COMMENT '编辑人',
    `update_on`   datetime    DEFAULT NULL COMMENT '编辑时间',
    `delete_flag` int         NOT NULL COMMENT '未删除：0 ,已删除：1',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;