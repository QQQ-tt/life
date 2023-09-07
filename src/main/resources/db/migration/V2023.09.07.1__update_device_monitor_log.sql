ALTER TABLE `device_monitor_log`
    MODIFY COLUMN `is_his` bit(1) NULL DEFAULT 0 COMMENT '历史记录' AFTER `device_user_id`;