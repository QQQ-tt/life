package com.tqsm.life.controller;

import com.tqsm.life.config.Result;
import com.tqsm.life.entity.AlarmSetting;
import com.tqsm.life.entity.UserManagement;
import com.tqsm.life.pojo.dto.DeviceAlertDTO;
import com.tqsm.life.pojo.vo.DeviceAlertQueryVO;
import com.tqsm.life.service.AlarmSettingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 警报参数设置表 前端控制器
 * </p>
 *
 * @author xnd
 * @since 2023-11-01
 */
@Tag(name = "警报参数设置")
@RestController
@RequestMapping("/life/alarmSetting")
public class AlarmSettingController {

    @Resource
    private AlarmSettingService alarmSettingService;

    @PostMapping("/saveOrUpdateNew")
    @Operation(summary = "警报设置-新增或编辑")
    public Result<Boolean> saveOrUpdateNew(@RequestBody AlarmSetting dto) {
        return Result.success(alarmSettingService.saveOrUpdateNew(dto));
    }

    @PostMapping("/alertUpdate")
    @Operation(summary = "警报预警开启/关闭")
    public Result<Boolean> alertUpdate(@RequestBody DeviceAlertDTO dto) {
        return Result.success(alarmSettingService.alertUpdate(dto));
    }

    @PostMapping("/alertQuery")
    @Operation(summary = "警报预警按钮状态查询")
    public Result<DeviceAlertQueryVO> alertQuery(@RequestParam int deviceId) {
        return Result.success(alarmSettingService.alertQuery(deviceId));
    }

    @GetMapping("/queryAlarmSettingById")
    @Operation(summary = "设置查询")
    public Result<AlarmSetting> queryAlarmSetting(@RequestParam int deviceId) {
        return Result.success(alarmSettingService.queryAlarmSetting(deviceId));
    }

}
