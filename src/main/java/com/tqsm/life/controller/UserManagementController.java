package com.tqsm.life.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.config.Result;
import com.tqsm.life.entity.UserManagement;
import com.tqsm.life.pojo.dto.UserManagementDTO;
import com.tqsm.life.pojo.vo.UserManagementHisVO;
import com.tqsm.life.pojo.vo.UserManagementVO;
import com.tqsm.life.service.UserManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qtx
 * @since 2023-08-31
 */
@Tag(name = "人员管理")
@RestController
@RequestMapping("/life/userManagement")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/saveOrUpdateNew")
    @Operation(summary = "人员管理-新增或编辑")
    public Result<Boolean> saveOrUpdateNew(@RequestBody UserManagement dto) {
        return Result.success(userManagementService.saveOrUpdateNew(dto));
    }

    @PostMapping("/listUserManagementPage")
    @Operation(summary = "人员管理分页查询")
    public Result<IPage<UserManagementVO>> listUserManagementPage(@RequestBody UserManagementDTO dto) {
        return Result.success(userManagementService.listUserManagementPage(dto));
    }

    @PostMapping("/userForHisList")
    @Operation(summary = "His获取")
    public Result<IPage<UserManagementHisVO>> userForHisList(@RequestBody UserManagementDTO dto) {
        return Result.success(userManagementService.userForHisList(dto));
    }


    @PostMapping("/saveBatchUser")
    @Operation(summary = "批量插入患者")
    public Result<Boolean> saveBatchUser(@RequestBody List<UserManagement> dto) {
        return Result.success(userManagementService.saveBatchUser(dto));
    }


    @DeleteMapping("/removeById")
    @Operation(summary = "删除")
    public Result<Boolean> removeById(@RequestParam Integer id) {
        return Result.success(userManagementService.removeById(id));
    }


}
