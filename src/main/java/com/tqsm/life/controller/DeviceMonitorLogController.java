package com.tqsm.life.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.config.Result;
import com.tqsm.life.pojo.dto.DeviceMonitorLogDTO;
import com.tqsm.life.pojo.vo.DeviceMonitorLogPageVO;
import com.tqsm.life.service.DeviceMonitorLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 设备监测记录 前端控制器
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
@Tag(name = "监测记录")
@RestController
@RequestMapping("/life/deviceMonitorLog")
public class DeviceMonitorLogController {

    private final DeviceMonitorLogService service;

    public DeviceMonitorLogController(DeviceMonitorLogService service) {
        this.service = service;
    }

    @Operation(summary = "开始监测/结束监测")
    @GetMapping("/theRecordingStartsAndEnds")
    public Object theRecordingStartsAndEnds(@RequestParam int deviceUserId){
        return Result.success(service.theRecordingStartsAndEnds(deviceUserId));
    }

    @Operation(summary = "历史记录列表")
    @PostMapping("/historyPage")
    public Result<IPage<DeviceMonitorLogPageVO>> historyPage(@RequestBody DeviceMonitorLogDTO dto){
        return Result.success(service.historyPage(dto));
    }
}
