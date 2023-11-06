package com.tqsm.life.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tqsm.life.entity.DeviceUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tqsm.life.pojo.dto.DeviceUserPageDTO;
import com.tqsm.life.pojo.vo.DeviceUserPageVO;
import com.tqsm.life.pojo.vo.UserManagementVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 设备患者关联表 Mapper 接口
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
@Mapper
public interface DeviceUserMapper extends BaseMapper<DeviceUser> {

    IPage<DeviceUserPageVO> listDeviceUserPage(Page<UserManagementVO> page,@Param("pageDTO")DeviceUserPageDTO dto);

}
