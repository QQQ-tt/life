package com.tqsm.life.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.entity.DeviceMonitorLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tqsm.life.pojo.dto.DeviceMonitorLogDTO;
import com.tqsm.life.pojo.vo.DeviceMonitorLogPageVO;

/**
 * <p>
 * 设备监测记录 服务类
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
public interface DeviceMonitorLogService extends IService<DeviceMonitorLog> {

    boolean theRecordingStartsAndEnds(int deviceUserId);

    IPage<DeviceMonitorLogPageVO> historyPage(DeviceMonitorLogDTO dto);
}
