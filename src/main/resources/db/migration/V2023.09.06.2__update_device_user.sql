ALTER TABLE `device_user`
    MODIFY COLUMN `is_his` bit(1) NULL DEFAULT 0 COMMENT '历史记录' AFTER `user_id`;