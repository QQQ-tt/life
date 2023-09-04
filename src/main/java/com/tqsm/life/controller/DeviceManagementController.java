package com.tqsm.life.controller;

import com.tqsm.life.config.Result;
import com.tqsm.life.service.DeviceManagementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/listDevice")
    public Object listDevice(){
        return Result.success();
    }
}
