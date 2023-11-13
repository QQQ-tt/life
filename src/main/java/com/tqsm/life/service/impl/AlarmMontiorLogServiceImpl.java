package com.tqsm.life.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tqsm.life.config.Constants;
import com.tqsm.life.entity.AlarmMontiorLog;
import com.tqsm.life.mapper.life.AlarmMontiorLogMapper;
import com.tqsm.life.pojo.dto.AlarmMontiorLogDTO;
import com.tqsm.life.pojo.vo.AlarmMontiorLogPageVO;
import com.tqsm.life.service.AlarmMontiorLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 警报异常记录表 服务实现类
 * </p>
 *
 * @author xnd
 * @since 2023-11-03
 */
@Service
public class AlarmMontiorLogServiceImpl extends ServiceImpl<AlarmMontiorLogMapper, AlarmMontiorLog> implements AlarmMontiorLogService {

    @Autowired
    private AlarmMontiorLogMapper alarmMontiorLogMapper;

    @Override
    public IPage<AlarmMontiorLogPageVO> alarmMontiorLogHistory(AlarmMontiorLogDTO dto) {
        Page<AlarmMontiorLogPageVO> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        IPage<AlarmMontiorLogPageVO> alarmMontiorLogPageVOIPage = null;
        if (dto.getTable().equals(Constants.TABLE_HIS)) {
            alarmMontiorLogPageVOIPage = alarmMontiorLogMapper.alarmMontiorLogHistory(page, dto);
        }else if (dto.getTable().equals(Constants.TABLE_NOW)){
            alarmMontiorLogPageVOIPage = alarmMontiorLogMapper.alarmMontiorLogNow(page, dto);
        }
        return alarmMontiorLogPageVOIPage;
    }
}
