package com.tqsm.life.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tqsm.life.entity.DeviceUser;
import com.tqsm.life.interfaces.LifeClient;
import com.tqsm.life.mapper.DeviceUserMapper;
import com.tqsm.life.pojo.dto.DeviceUserPageDTO;
import com.tqsm.life.pojo.life.result.cache.ResultCache;
import com.tqsm.life.pojo.life.result.cache.datas;
import com.tqsm.life.pojo.vo.*;
import com.tqsm.life.service.DeviceUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 设备患者关联表 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2023-09-04
 */
@Service
public class DeviceUserServiceImpl extends ServiceImpl<DeviceUserMapper, DeviceUser> implements DeviceUserService {

    @Autowired
    private DeviceUserMapper deviceUserMapper;

    @Autowired
    private LifeClient lifeClient;

    @Override
    public IPage<DeviceUserPageVO> listDeviceUserPage(DeviceUserPageDTO dto) {
        Page<UserManagementVO> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        return deviceUserMapper.listDeviceUserPage(page, dto);
    }

    @Override
    public HistoricalParticularsVO historyDetails(String id, LocalDateTime bTime, LocalDateTime eTime) {
        HistoricalParticularsVO h = new HistoricalParticularsVO();
        List<HistoricalHrExceptionVO> hrExceptionVOList = new ArrayList<>();
        List<HistoricalBrExceptionVO> brExceptionVOList = new ArrayList<>();
        HistoricalHrExceptionVO hrExceptionVO = null;
        HistoricalBrExceptionVO brExceptionVO = null;
        ResultCache cache = lifeClient.cache(id, bTime, eTime);
        if (cache.getCode() != 0) {
            throw new RuntimeException(cache.getMessage());
        }
        List<datas> datas = cache.getDatas();
        h.setState(cache.getCode());
        if (!datas.isEmpty()) {
            //收缩压
            List<Integer> sbps = datas.stream().map(com.tqsm.life.pojo.life.result.cache.datas::getSbp).toList();
            //舒张压
            List<Integer> dbps = datas.stream().map(com.tqsm.life.pojo.life.result.cache.datas::getDbp).toList();
            //体动
            List<Integer> movingCounts = datas.stream()
                    .map(com.tqsm.life.pojo.life.result.cache.datas::getMovingCount)
                    .toList();
            if (!sbps.isEmpty() && !dbps.isEmpty()) {
                h.setDbp(dbps);
                h.setSbp(sbps);
            }
            if (!movingCounts.isEmpty()) {
                h.setMovingCount(movingCounts);
            }
        }
        for (datas t : datas) {
            hrExceptionVO = new HistoricalHrExceptionVO();
            brExceptionVO = new HistoricalBrExceptionVO();
            Integer br = t.getBr();
            Integer brException = t.getBrException();
            if (br != null && brException != null) {
                brExceptionVO.setBr(br);
                brExceptionVO.setBr_exception(brException);
            }
            Integer hr = t.getHr();
            Integer hrException = t.getHrException();
            if (hr != null && hrException != null) {
                hrExceptionVO.setHr(hr);
                hrExceptionVO.setHrException(hrException);
            }
            brExceptionVOList.add(brExceptionVO);
            hrExceptionVOList.add(hrExceptionVO);
        }
        h.setHrList(hrExceptionVOList);
        h.setBrList(brExceptionVOList);
        return h;
    }
}
