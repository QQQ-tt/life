package com.tqsm.life.mapper.life;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tqsm.life.entity.UserManagement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tqsm.life.pojo.dto.UserManagementDTO;
import com.tqsm.life.pojo.vo.UserManagementHisVO;
import com.tqsm.life.pojo.vo.UserManagementVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * @return 查询条数
     */
    IPage<UserManagementVO> listUserManagementPage(Page<UserManagementVO> page,@Param("pageDTO") UserManagementDTO dto);

    /**
     * 批量插入HIS患者
     * @param dto
     * @return 插入条数
     */
    boolean saveBatchUser(@Param("records")List<UserManagement> dto);
}
