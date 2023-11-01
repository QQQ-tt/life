package com.tqsm.life.controller;

import com.tqsm.life.config.Result;
import com.tqsm.life.entity.AlarmSetting;
import com.tqsm.life.entity.UserManagement;
import com.tqsm.life.service.AlarmSettingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
