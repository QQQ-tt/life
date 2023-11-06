ALTER TABLE `life`.`alarm_setting`
    ADD COLUMN `device_id` int NOT NULL COMMENT '设备id' AFTER `id`;