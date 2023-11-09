package com.tqsm.life.service;

import com.tqsm.life.entity.AlarmSetting;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tqsm.life.pojo.dto.DeviceAlertDTO;
import com.tqsm.life.pojo.vo.DeviceAlertQueryVO;

/**
 * <p>
 * 警报参数设置表 服务类
 * </p>
 *
 * @author xnd
 * @since 2023-11-01
 */
public interface AlarmSettingService extends IService<AlarmSetting> {

    boolean saveOrUpdateNew(AlarmSetting dto);

    AlarmSetting queryAlarmSetting(int deviceId);

    boolean alertUpdate(DeviceAlertDTO dto);

    DeviceAlertQueryVO alertQuery(int deviceId);
}
