package com.tqsm.life.mapper.life;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tqsm.life.entity.AlarmMontiorLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tqsm.life.pojo.dto.AlarmMontiorLogDTO;
import com.tqsm.life.pojo.vo.AlarmMontiorLogPageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 警报异常记录表 Mapper 接口
 * </p>
 *
 * @author xnd
 * @since 2023-11-03
 */
@Mapper
public interface AlarmMontiorLogMapper extends BaseMapper<AlarmMontiorLog> {

    IPage<AlarmMontiorLogPageVO> alarmMontiorLogHistory(Page<AlarmMontiorLogPageVO> page,
                                                        @Param("pageDTO") AlarmMontiorLogDTO dto);

    IPage<AlarmMontiorLogPageVO> alarmMontiorLogNow(Page<AlarmMontiorLogPageVO> page,
                                                    @Param("nowDTO") AlarmMontiorLogDTO dto);
}
