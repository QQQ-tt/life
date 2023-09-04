ALTER TABLE `device_monitor_log`
    CHANGE COLUMN `device_id` `device_user_id` int NULL DEFAULT NULL AFTER `id`;