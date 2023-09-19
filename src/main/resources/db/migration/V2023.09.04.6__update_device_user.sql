ALTER TABLE `device_user`
    MODIFY COLUMN `device_id` int NULL DEFAULT NULL COMMENT '设备id' AFTER `id`,
    ADD COLUMN `user_id` int NULL COMMENT '患者id' AFTER `device_id`,
    COMMENT = '设备患者关联表';