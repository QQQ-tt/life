package com.tqsm.life.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tqsm.life.entity.DeviceUser;
import com.tqsm.life.interfaces.LifeClient;
import com.tqsm.life.mapper.DeviceUserMapper;
import com.tqsm.life.pojo.dto.DeviceUserPageDTO;
import com.tqsm.life.pojo.life.result.cache.ResultCache;
import com.tqsm.life.pojo.life.result.cache.datas;
import com.tqsm.life.pojo.vo.DeviceUserPageVO;
import com.tqsm.life.pojo.vo.HistoricalParticularsVO;
import com.tqsm.life.pojo.vo.UserManagementVO;
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
        HistoricalParticularsVO h =new HistoricalParticularsVO();
        ResultCache cache = lifeClient.cache(id, bTime, eTime);
        if (cache.getCode() != 0) {
            throw new RuntimeException(cache.getMessage());
        }
        List<datas> datas = cache.getDatas();
        h.setState(cache.getCode());
        if (!datas.isEmpty()) {
            List<Integer> hrs = datas.stream().map(com.tqsm.life.pojo.life.result.cache.datas::getHr).toList();
            List<Integer> brs = datas.stream().map(com.tqsm.life.pojo.life.result.cache.datas::getBr).toList();
            List<Integer> sbps = datas.stream().map(com.tqsm.life.pojo.life.result.cache.datas::getSbp).toList();
            List<Integer> dbps = datas.stream().map(com.tqsm.life.pojo.life.result.cache.datas::getDbp).toList();
            List<Integer> movingCounts = datas.stream().map(com.tqsm.life.pojo.life.result.cache.datas::getMovingCount).toList();
            h.setHr(hrs);
            h.setBr(brs);
            h.setDbp(dbps);
            h.setSbp(sbps);
            h.setMovingCount(movingCounts);
        }
        return h;
    }
}
