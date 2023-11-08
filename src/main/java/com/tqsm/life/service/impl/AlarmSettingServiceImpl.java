package com.tqsm.life.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.tqsm.life.entity.AlarmSetting;
import com.tqsm.life.mapper.AlarmSettingMapper;
import com.tqsm.life.pojo.dto.DeviceAlertDTO;
import com.tqsm.life.service.AlarmSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 警报参数设置表 服务实现类
 * </p>
 *
 * @author xnd
 * @since 2023-11-01
 */
@Service
public class AlarmSettingServiceImpl extends ServiceImpl<AlarmSettingMapper, AlarmSetting> implements AlarmSettingService {


    @Resource
    private  AlarmSettingMapper alarmSettingMapper;

    @Override
    public boolean saveOrUpdateNew(AlarmSetting dto) {
        Integer switches = dto.getSwitches();
        //选择定时关闭后弹窗时间赋值0
        if (switches.equals(1)){
            dto.setTims(0);
        }
        return saveOrUpdate(dto);
    }

    @Override
    public AlarmSetting queryAlarmSetting(int deviceId) {
        return alarmSettingMapper.getOne(deviceId);
    }

    @Override
    public boolean alertUpdate(DeviceAlertDTO dto) {
        boolean update = false;
        if (dto.getType().equals(1)){
            LambdaUpdateWrapper<AlarmSetting> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
            lambdaUpdateWrapper.eq(AlarmSetting::getDeviceId, dto.getDeviceId())
                    .set(AlarmSetting::getBpAlert,dto.getAble());
             update = update(lambdaUpdateWrapper);
        }
        if (dto.getType().equals(2)){
            LambdaUpdateWrapper<AlarmSetting> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
            lambdaUpdateWrapper.eq(AlarmSetting::getDeviceId, dto.getDeviceId())
                    .set(AlarmSetting::getHrAlert,dto.getAble());
            update = update(lambdaUpdateWrapper);
        }
        if (dto.getType().equals(3)){
            LambdaUpdateWrapper<AlarmSetting> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
            lambdaUpdateWrapper.eq(AlarmSetting::getDeviceId, dto.getDeviceId())
                    .set(AlarmSetting::getBrAlert,dto.getAble());
            update = update(lambdaUpdateWrapper);
        }
        return update;
    }
}
