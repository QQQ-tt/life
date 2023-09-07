package com.tqsm.life.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tqsm.life.entity.DeviceMonitorLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tqsm.life.pojo.dto.DeviceMonitorLogDTO;
import com.tqsm.life.pojo.vo.DeviceMonitorLogPageVO;
import com.tqsm.life.pojo.vo.UserManagementVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 设备监测记录 Mapper 接口
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
@Mapper
public interface DeviceMonitorLogMapper extends BaseMapper<DeviceMonitorLog> {

    IPage<DeviceMonitorLogPageVO> historyPage(IPage<DeviceMonitorLog> page,@Param("pageDTO") DeviceMonitorLogDTO dto);
}
