ALTER TABLE `life`.`alarm_setting`
    ADD COLUMN `bp_alert` int NULL COMMENT '血压预警开关（0:开启，1:关闭）' AFTER `dbp_right`,
ADD COLUMN `hr_alert` int NULL COMMENT '心电图预警开关（0:开启,1:关闭）' AFTER `bp_alert`,
ADD COLUMN `br_alert` int NULL COMMENT '呼吸预警开关(0:开启，1:关闭)' AFTER `hr_alert`;