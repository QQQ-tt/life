package com.tqsm.life.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tqsm.life.entity.DeviceManagement;
import com.tqsm.life.mapper.DeviceManagementMapper;
import com.tqsm.life.pojo.dto.DeviceManagementDTO;
import com.tqsm.life.pojo.vo.DeviceManagementVO;
import com.tqsm.life.service.DeviceManagementService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备管理 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2023-08-31
 */
@Service
public class DeviceManagementServiceImpl extends ServiceImpl<DeviceManagementMapper, DeviceManagement> implements DeviceManagementService {


    @Override
    public IPage<DeviceManagementVO> listDevice(DeviceManagementDTO dto) {

        return null;
    }
}
