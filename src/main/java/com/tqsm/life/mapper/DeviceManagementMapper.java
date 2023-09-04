package com.tqsm.life.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.entity.DeviceManagement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tqsm.life.pojo.dto.DeviceManagementDTO;
import com.tqsm.life.pojo.vo.DeviceManagementVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 设备管理 Mapper 接口
 * </p>
 *
 * @author qtx
 * @since 2023-08-31
 */
@Mapper
public interface DeviceManagementMapper extends BaseMapper<DeviceManagement> {

    IPage<DeviceManagementVO> selectPageNew(IPage<Object> page,@Param("dto") DeviceManagementDTO dto);
}
