ALTER TABLE `life`.`alarm_montior_log`
    ADD COLUMN `reference_interval` varchar(255) NOT NULL COMMENT '参考值区间' AFTER `exception_value`;