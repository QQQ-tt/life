package com.tqsm.life.service;

import com.tqsm.life.entity.DeviceHeartbeat;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 设备心跳记录 服务类
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
public interface DeviceHeartbeatService extends IService<DeviceHeartbeat> {

    void deviceHeart();
}
