package com.tqsm.life.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.config.Result;
import com.tqsm.life.interfaces.LifeClient;
import com.tqsm.life.pojo.dto.DeviceUserPageDTO;
import com.tqsm.life.pojo.dto.UserManagementDTO;
import com.tqsm.life.pojo.life.result.cache.ResultCache;
import com.tqsm.life.pojo.vo.DeviceParticularsVO;
import com.tqsm.life.pojo.vo.DeviceUserPageVO;
import com.tqsm.life.pojo.vo.HistoricalParticularsVO;
import com.tqsm.life.pojo.vo.UserManagementVO;
import com.tqsm.life.service.DeviceUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @Operation(summary = "历史记录详情")
    @GetMapping("/historyDetails")
    public Result<HistoricalParticularsVO> historyDetails(@RequestParam String id,
                                                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                                      LocalDateTime bTime, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime eTime) {
        return Result.success(deviceUserService.historyDetails(id, bTime, eTime));
    }

}
