ALTER TABLE `life`.`alarm_setting`
    CHANGE COLUMN `switch` `switches` int NOT NULL DEFAULT 0 COMMENT '开启：0 ,关闭：1' AFTER `tims`;