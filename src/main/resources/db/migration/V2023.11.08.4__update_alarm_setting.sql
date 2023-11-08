ALTER TABLE `life`.`alarm_setting`
    MODIFY COLUMN `bp_alert` int NULL DEFAULT NULL COMMENT '血压预警开关（0:开启，1:关闭）' AFTER `dbp_right`,
    MODIFY COLUMN `hr_alert` int NULL DEFAULT NULL COMMENT '心电图预警开关（0:开启,1:关闭）' AFTER `bp_alert`,
    MODIFY COLUMN `br_alert` int NULL DEFAULT NULL COMMENT '呼吸预警开关(0:开启，1:关闭)' AFTER `hr_alert`;