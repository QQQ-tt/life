package com.tqsm.life.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.config.Result;
import com.tqsm.life.pojo.dto.AlarmMontiorLogDTO;
import com.tqsm.life.pojo.dto.DeviceMonitorLogDTO;
import com.tqsm.life.pojo.vo.AlarmMontiorLogPageVO;
import com.tqsm.life.pojo.vo.DeviceMonitorLogPageVO;
import com.tqsm.life.service.AlarmMontiorLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 警报异常记录表 前端控制器
 * </p>
 *
 * @author xnd
 * @since 2023-11-03
 */
@Tag(name = "查看异常记录")
@RestController
@RequestMapping("/life/alarmMontiorLog")
public class AlarmMontiorLogController {

    @Resource
    private AlarmMontiorLogService alarmMontiorLogService;

    @Operation(summary = "查看异常记录历史")
    @PostMapping("/alarmMontiorLogHistory")
    public Result<IPage<AlarmMontiorLogPageVO>> alarmMontiorLogHistory(@RequestBody AlarmMontiorLogDTO dto){
        return Result.success(alarmMontiorLogService.alarmMontiorLogHistory(dto));
    }

}
