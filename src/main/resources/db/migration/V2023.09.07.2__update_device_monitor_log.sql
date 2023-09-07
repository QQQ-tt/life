ALTER TABLE `device_monitor_log`
    MODIFY COLUMN `delete_flag` bit NOT NULL DEFAULT 0 COMMENT '未删除：0 ,已删除：1' AFTER `update_on`;
