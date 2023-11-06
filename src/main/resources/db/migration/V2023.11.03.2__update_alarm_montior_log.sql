ALTER TABLE `life`.`alarm_montior_log`
    ADD COLUMN `device_code` varchar(50) NOT NULL COMMENT '设备编号' AFTER `id`;