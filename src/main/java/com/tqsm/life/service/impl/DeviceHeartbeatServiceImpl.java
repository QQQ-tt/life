package com.tqsm.life.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tqsm.life.entity.DeviceHeartbeat;
import com.tqsm.life.entity.DeviceManagement;
import com.tqsm.life.interfaces.LifeClient;
import com.tqsm.life.mapper.DeviceHeartbeatMapper;
import com.tqsm.life.pojo.life.PersonState;
import com.tqsm.life.service.DeviceHeartbeatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tqsm.life.service.DeviceManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 设备心跳记录 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
@Slf4j
@Service
public class DeviceHeartbeatServiceImpl extends ServiceImpl<DeviceHeartbeatMapper, DeviceHeartbeat> implements DeviceHeartbeatService {

    private boolean state = true;

    private final LifeClient lifeClient;

    private final DeviceManagementService deviceManagementService;

    public DeviceHeartbeatServiceImpl(LifeClient lifeClient, DeviceManagementService deviceManagementService) {
        this.lifeClient = lifeClient;
        this.deviceManagementService = deviceManagementService;
    }

    @Override
    //@Scheduled(fixedDelay = 5000)
    @Transactional(rollbackFor = Exception.class)
    public void deviceHeart() {
        if (state) {
            state = false;
            try {
                log.info("设备心跳记录...");
                List<DeviceManagement> list = deviceManagementService.list();
                remove(Wrappers.lambdaUpdate());
                List<DeviceHeartbeat> heartbeats = new ArrayList<>();
                list.forEach(e -> {
                    String deviceCode = e.getDeviceCode();
                    PersonState person = lifeClient.isPerson(deviceCode);
                    boolean no = !"无人".equals(person.getText());
                    boolean online = "0".equals(person.getCode());
                    save(DeviceHeartbeat.builder()
                            .build());
                    heartbeats.add(DeviceHeartbeat.builder()
                            .deviceId(e.getId())
                            .person(no)
                            .online(online)
                            .build());
                });
                saveBatch(heartbeats);
            } finally {
                state = true;
            }
        }
    }

}
