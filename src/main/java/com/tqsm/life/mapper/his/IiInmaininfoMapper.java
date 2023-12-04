package com.tqsm.life.mapper.his;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tqsm.life.entity.IiInmaininfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tqsm.life.pojo.dto.UserManagementDTO;
import com.tqsm.life.pojo.vo.UserManagementHisVO;
import com.tqsm.life.pojo.vo.UserManagementVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * II_住院主表 Mapper 接口
 * </p>
 *
 * @author xnd
 * @since 2023-11-10
 */
@Mapper
public interface IiInmaininfoMapper extends BaseMapper<IiInmaininfo> {
    /**
     * 根据住院证号 从HIS获取 住院人员
     * @param page
     * @param dto
     * @return
     */
    IPage<UserManagementHisVO> userForHisList(Page<UserManagementVO> page,@Param("dto")UserManagementDTO dto);
}
