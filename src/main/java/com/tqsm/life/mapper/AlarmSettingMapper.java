package com.tqsm.life.mapper;

import com.tqsm.life.entity.AlarmSetting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tqsm.life.pojo.vo.DeviceAlertQueryVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 警报参数设置表 Mapper 接口
 * </p>
 *
 * @author xnd
 * @since 2023-11-01
 */
@Mapper
public interface AlarmSettingMapper extends BaseMapper<AlarmSetting> {

    AlarmSetting selectAlarm(String userId);

    AlarmSetting getOne(int deviceId);

    DeviceAlertQueryVO alertQuery(int deviceId);
}
