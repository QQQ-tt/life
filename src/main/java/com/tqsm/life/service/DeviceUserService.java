package com.tqsm.life.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.entity.DeviceUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tqsm.life.pojo.dto.DeviceUserPageDTO;
import com.tqsm.life.pojo.vo.DeviceUserPageVO;
import com.tqsm.life.pojo.vo.HistoricalParticularsVO;

import java.time.LocalDateTime;

/**
 * <p>
 * 设备患者关联表 服务类
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
public interface DeviceUserService extends IService<DeviceUser> {


    IPage<DeviceUserPageVO> listDeviceUserPage(DeviceUserPageDTO dto);

    HistoricalParticularsVO historyDetails(String id, LocalDateTime bTime, LocalDateTime eTime);
}
