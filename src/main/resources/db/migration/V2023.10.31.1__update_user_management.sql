ALTER TABLE `life`.`user_management`
    ADD COLUMN `inpatient_no` varchar(100) NULL COMMENT '住院证号' AFTER `tel`;