package com.tqsm.life.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tqsm.life.entity.UserManagement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tqsm.life.pojo.dto.UserManagementDTO;
import com.tqsm.life.pojo.vo.UserManagementVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qtx
 * @since 2023-08-31
 */
@Mapper
public interface UserManagementMapper extends BaseMapper<UserManagement> {

    /**
     * 人员管理分页查询
     * @param page
     * @param dto
     * @return
     */
    IPage<UserManagementVO> listUserManagementPage(Page<UserManagementVO> page,@Param("pageDTO") UserManagementDTO dto);
}
