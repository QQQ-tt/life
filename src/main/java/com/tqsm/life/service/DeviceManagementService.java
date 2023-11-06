package com.tqsm.life.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.entity.DeviceManagement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tqsm.life.pojo.dto.DeviceManagementDTO;
import com.tqsm.life.pojo.vo.DeviceManagementVO;
import com.tqsm.life.pojo.vo.DeviceParticularsVO;

/**
 * <p>
 * 设备管理 服务类
 * </p>
 *
 * @author qtx
 * @since 2023-08-31
 */
public interface DeviceManagementService extends IService<DeviceManagement> {

    IPage<DeviceManagementVO> listDevice(DeviceManagementDTO dto);

    void getDeviceInfoByDeviceId(int deviceId);

    boolean saveOrUpdateDevice(DeviceManagement deviceManagement);

    DeviceManagementVO bindThePatient(int deviceId, int userId);

    DeviceManagementVO relieveThePatient(int deviceId);

    boolean testDevice(String deviceCode);

    boolean removeByDeviceId(int deviceId);

    DeviceParticularsVO particulars(String userId);
}
