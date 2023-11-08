package com.tqsm.life.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tqsm.life.entity.UserManagement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tqsm.life.pojo.dto.UserManagementDTO;
import com.tqsm.life.pojo.vo.UserManagementHisVO;
import com.tqsm.life.pojo.vo.UserManagementVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qtx
 * @since 2023-08-31
 */
public interface UserManagementService extends IService<UserManagement> {

    boolean saveOrUpdateNew(UserManagement dto);

    IPage<UserManagementVO> listUserManagementPage(UserManagementDTO dto);

    IPage<UserManagementHisVO> userForHisList(UserManagementDTO dto);
}
