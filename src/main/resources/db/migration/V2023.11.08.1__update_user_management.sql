ALTER TABLE `life`.`user_management`
    ADD COLUMN `type` int NULL DEFAULT 0 COMMENT '来源（1：新建，2：his获取）' AFTER `inpatient_no`;