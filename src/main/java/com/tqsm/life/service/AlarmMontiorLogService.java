package com.tqsm.life.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.entity.AlarmMontiorLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tqsm.life.pojo.dto.AlarmMontiorLogDTO;
import com.tqsm.life.pojo.vo.AlarmMontiorLogPageVO;
import com.tqsm.life.pojo.vo.DeviceMonitorLogPageVO;

/**
 * <p>
 * 警报异常记录表 服务类
 * </p>
 *
 * @author xnd
 * @since 2023-11-03
 */
public interface AlarmMontiorLogService extends IService<AlarmMontiorLog> {

    IPage<AlarmMontiorLogPageVO> alarmMontiorLogHistory(AlarmMontiorLogDTO dto);
}
