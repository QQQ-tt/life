package com.tqsm.life.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tqsm.life.entity.DeviceUser;
import com.tqsm.life.mapper.DeviceUserMapper;
import com.tqsm.life.pojo.dto.DeviceUserPageDTO;
import com.tqsm.life.pojo.vo.DeviceUserPageVO;
import com.tqsm.life.pojo.vo.UserManagementVO;
import com.tqsm.life.service.DeviceUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备患者关联表 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
@Service
public class DeviceUserServiceImpl extends ServiceImpl<DeviceUserMapper, DeviceUser> implements DeviceUserService {

    @Autowired
    private DeviceUserMapper deviceUserMapper;

    @Override
    public IPage<DeviceUserPageVO> listDeviceUserPage(DeviceUserPageDTO dto) {
        Page<UserManagementVO> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        return deviceUserMapper.listDeviceUserPage(page, dto);
    }
}
