package com.tqsm.life.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.config.Result;
import com.tqsm.life.entity.DeviceManagement;
import com.tqsm.life.pojo.dto.DeviceManagementDTO;
import com.tqsm.life.pojo.vo.DeviceManagementVO;
import com.tqsm.life.pojo.vo.DeviceParticularsVO;
import com.tqsm.life.service.DeviceManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 设备管理 前端控制器
 * </p>
 *
 * @author qtx
 * @since 2023-08-31
 */
@Tag(name = "设备管理")
@RestController
@RequestMapping("/life/deviceManagement")
public class DeviceManagementController {

    private final DeviceManagementService service;

    public DeviceManagementController(DeviceManagementService service) {
        this.service = service;
    }

    @Operation(summary = "分页查询设备")
    @PostMapping("/listDevicePage")
    public Result<IPage<DeviceManagementVO>> listDevicePage(@RequestBody DeviceManagementDTO dto) {
        return Result.success(service.listDevice(dto));
    }

    @Operation(summary = "设备编辑")
    @PostMapping("/saveOrUpdateDevice")
    public Result<Boolean> saveOrUpdateDevice(@RequestBody DeviceManagement deviceManagement) {
        return Result.success(service.saveOrUpdateDevice(deviceManagement));
    }

    @Operation(summary = "设备绑定")
    @GetMapping("/bindThePatient")
    public Result<Boolean> bindThePatient(@RequestParam int deviceId, @RequestParam int userId) {
        return Result.success(service.bindThePatient(deviceId, userId));
    }

    @Operation(summary = "解除绑定")
    @GetMapping("/relieveThePatient")
    public Result<Boolean> relieveThePatient(@RequestParam int deviceId) {
        return Result.success(service.relieveThePatient(deviceId));
    }


    @Operation(summary = "设备连接测试")
    @GetMapping("/testDevice")
    public Result<Boolean> testDevice(@RequestParam String deviceCode) {
        return Result.success(service.testDevice(deviceCode));
    }

    @Operation(summary = "设备删除")
    @DeleteMapping("/removeByDeviceId")
    public Result<Boolean> removeByDeviceId(@RequestParam int deviceId) {
        return Result.success(service.removeByDeviceId(deviceId));
    }

    @Operation(summary = "详情")
    @GetMapping("/particulars")
    public Result<DeviceParticularsVO> particulars(@RequestParam String deviceCode) {
        return Result.success(service.particulars(deviceCode));
    }

}
