package com.tqsm.life.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.entity.DeviceManagement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tqsm.life.pojo.dto.DeviceManagementDTO;
import com.tqsm.life.pojo.vo.DeviceManagementVO;

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

}
