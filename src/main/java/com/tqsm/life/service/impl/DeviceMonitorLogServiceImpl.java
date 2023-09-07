package com.tqsm.life.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tqsm.life.config.BaseEntity;
import com.tqsm.life.config.exception.DataEnums;
import com.tqsm.life.config.exception.DataException;
import com.tqsm.life.entity.DeviceMonitorLog;
import com.tqsm.life.entity.DeviceUser;
import com.tqsm.life.mapper.DeviceMonitorLogMapper;
import com.tqsm.life.service.DeviceMonitorLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tqsm.life.service.DeviceUserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 设备监测记录 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
@Service
public class DeviceMonitorLogServiceImpl extends ServiceImpl<DeviceMonitorLogMapper, DeviceMonitorLog> implements DeviceMonitorLogService {

    private final DeviceUserService deviceUserService;

    public DeviceMonitorLogServiceImpl(DeviceUserService deviceUserService) {
        this.deviceUserService = deviceUserService;
    }

    @Override
    public boolean theRecordingStartsAndEnds(int deviceUserId) {
        DeviceMonitorLog one = getOne(Wrappers.lambdaUpdate(DeviceMonitorLog.class)
                .eq(DeviceMonitorLog::getIsHis, Boolean.FALSE)
                .eq(DeviceMonitorLog::getDeviceUserId,
                        deviceUserId));
        if (Objects.isNull(one)) {
            long count = deviceUserService.count(Wrappers.lambdaQuery(DeviceUser.class)
                    .eq(BaseEntity::getId, deviceUserId)
                    .eq(DeviceUser::getIsHis, Boolean.FALSE));
            if (count == 1) {
                return save(DeviceMonitorLog.builder()
                        .deviceUserId(deviceUserId)
                        .build());
            }
            throw new DataException(DataEnums.DATA_IS_ABNORMAL);
        } else {
            return update(new DeviceMonitorLog(), Wrappers.lambdaUpdate(DeviceMonitorLog.class)
                    .eq(DeviceMonitorLog::getDeviceUserId, deviceUserId)
                    .eq(DeviceMonitorLog::getIsHis, Boolean.FALSE)
                    .set(DeviceMonitorLog::getIsHis, Boolean.TRUE));
        }
    }
}
