package com.tqsm.life.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.config.Result;
import com.tqsm.life.pojo.dto.DeviceUserPageDTO;
import com.tqsm.life.pojo.dto.UserManagementDTO;
import com.tqsm.life.pojo.vo.DeviceUserPageVO;
import com.tqsm.life.pojo.vo.UserManagementVO;
import com.tqsm.life.service.DeviceUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 设备患者关联表 前端控制器
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
@Tag(name = "监测人员列表")
@RestController
@RequestMapping("/life/deviceUser")
public class DeviceUserController {

    @Autowired
    private DeviceUserService deviceUserService;

    @PostMapping("/listDeviceUserPage")
    @Operation(summary = "监测人员列表分页查询")
    public Result<IPage<DeviceUserPageVO>> listDeviceUserPage(@RequestBody DeviceUserPageDTO dto) {
        return Result.success(deviceUserService.listDeviceUserPage(dto));
    }

}
