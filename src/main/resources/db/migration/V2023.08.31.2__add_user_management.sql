ALTER TABLE `life`.`user_management`
    MODIFY COLUMN `delete_flag` int NOT NULL DEFAULT 0 COMMENT '未删除：0 ,已删除：1' AFTER `update_on`;