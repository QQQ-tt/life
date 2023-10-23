package com.tqsm.life.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tqsm.life.config.BaseEntity;
import com.tqsm.life.config.exception.DataEnums;
import com.tqsm.life.config.exception.DataException;
import com.tqsm.life.entity.DeviceHeartbeat;
import com.tqsm.life.entity.DeviceManagement;
import com.tqsm.life.entity.DeviceUser;
import com.tqsm.life.interfaces.LifeClient;
import com.tqsm.life.mapper.DeviceManagementMapper;
import com.tqsm.life.pojo.dto.DeviceManagementDTO;
import com.tqsm.life.pojo.life.PersonState;
import com.tqsm.life.pojo.life.result.bp.Bp;
import com.tqsm.life.pojo.life.result.bp.Other;
import com.tqsm.life.pojo.life.result.bp.Result;
import com.tqsm.life.pojo.life.result.bp.ResultsBp;
import com.tqsm.life.pojo.life.result.bp.pub.figure.Br;
import com.tqsm.life.pojo.life.result.bp.pub.figure.Hr;
import com.tqsm.life.pojo.life.result.bp.pub.figure.ResultBpPubFigure;
import com.tqsm.life.pojo.life.result.fatigue.pub.PubSummary;
import com.tqsm.life.pojo.life.result.fatigue.pub.ResultsFatiguePub;
import com.tqsm.life.pojo.life.result.fatigue.pub.rhythm.ResultsFatiguePubRhythm;
import com.tqsm.life.pojo.vo.DeviceManagementVO;
import com.tqsm.life.pojo.vo.DeviceParticularsVO;
import com.tqsm.life.service.DeviceHeartbeatService;
import com.tqsm.life.service.DeviceManagementService;
import com.tqsm.life.service.DeviceMonitorLogService;
import com.tqsm.life.service.DeviceUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 设备管理 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2023-08-31
 */
@Service
public class DeviceManagementServiceImpl extends ServiceImpl<DeviceManagementMapper, DeviceManagement> implements DeviceManagementService {

    private final DeviceUserService deviceUserService;

    private final DeviceMonitorLogService deviceMonitorLogService;

    private final DeviceHeartbeatService deviceHeartbeatService;

    private final LifeClient lifeClient;

    public DeviceManagementServiceImpl(DeviceUserService deviceUserService, DeviceMonitorLogService deviceMonitorLogService, DeviceHeartbeatService deviceHeartbeatService, LifeClient lifeClient) {
        this.deviceUserService = deviceUserService;
        this.deviceMonitorLogService = deviceMonitorLogService;
        this.deviceHeartbeatService = deviceHeartbeatService;
        this.lifeClient = lifeClient;
    }

    @Override
    public IPage<DeviceManagementVO> listDevice(DeviceManagementDTO dto) {
        return baseMapper.selectPageNew(dto.getPage(), dto);
    }

    @Override
    public void getDeviceInfoByDeviceId(int deviceId) {

    }

    @Override
    public boolean saveOrUpdateDevice(DeviceManagement deviceManagement) {
        long count = count(Wrappers.lambdaUpdate(DeviceManagement.class)
                .eq(StringUtils.isNotBlank(deviceManagement.getDeviceCode()),
                        DeviceManagement::getDeviceCode,
                        deviceManagement.getDeviceCode())
                .ne(deviceManagement.getId() != null, BaseEntity::getId,
                        deviceManagement.getId()));
        if (count < 1) {
            return saveOrUpdate(deviceManagement);
        } else {
            throw new DataException(DataEnums.DATA_REPEAT);
        }
    }

    @Override
    public boolean bindThePatient(int deviceId, int userId) {
        deviceUserService.update(Wrappers.lambdaUpdate(DeviceUser.class)
                .eq(DeviceUser::getDeviceId, deviceId)
                .set(DeviceUser::getIsHis, Boolean.TRUE));
        return deviceUserService.save(DeviceUser.builder()
                .deviceId(deviceId)
                .userId(userId)
                .build());
    }

    @Override
    public boolean relieveThePatient(int deviceId) {
        return deviceUserService.update(Wrappers.lambdaUpdate(DeviceUser.class)
                .eq(DeviceUser::getDeviceId, deviceId)
                .set(DeviceUser::getIsHis, Boolean.TRUE));
    }

    @Override
    public boolean testDevice(String deviceCode) {
        boolean flag = false;
        PersonState person = lifeClient.isPerson(deviceCode);
        if (Objects.nonNull(person)) {
            String code = person.getCode();
            flag = "0".equals(code);
        }
        return flag;
    }

    @Override
    public boolean removeByDeviceId(int deviceId) {
        boolean remove = remove(Wrappers.lambdaQuery(DeviceManagement.class)
                .eq(BaseEntity::getId, deviceId));
        List<DeviceUser> list = deviceUserService.list(Wrappers.lambdaQuery(DeviceUser.class)
                .eq(DeviceUser::getDeviceId, deviceId));
        deviceUserService.remove(Wrappers.lambdaUpdate(DeviceUser.class)
                .eq(DeviceUser::getDeviceId, deviceId));
        deviceMonitorLogService.removeBatchByIds(list.stream()
                .map(BaseEntity::getId)
                .collect(Collectors.toList()));
        deviceHeartbeatService.remove(Wrappers.lambdaUpdate(DeviceHeartbeat.class)
                .eq(DeviceHeartbeat::getDeviceId,
                        deviceId));
        return remove;
    }

    @Override
    public DeviceParticularsVO particulars(String userId) {
        DeviceParticularsVO deviceParticularsVO = new DeviceParticularsVO();
        ResultsBp resultsBp = lifeClient.bloodPressure(userId);
        ResultsFatiguePubRhythm resultsFatiguePubRhythm = lifeClient.fatiguePubRhythm(userId);
        ResultBpPubFigure resultBpPubFigure = lifeClient.bloodPressurePubFigure(userId);
        PubSummary pubSummary = lifeClient.fatiguePubSummary(userId);
        ResultsFatiguePub resultsFatiguePub = lifeClient.fatiguePub(userId);
        if (resultsBp != null) {
            //血压计算结果
            Bp bp = resultsBp.getBp();
            Result result = resultsBp.getResult();
            Other other = resultsBp.getOther();
            deviceParticularsVO.setHr(result.getHr());
            deviceParticularsVO.setBr(result.getBr());
            deviceParticularsVO.setSbp(bp.getSbp());
            deviceParticularsVO.setDbp(bp.getDbp());
            deviceParticularsVO.setTs(bp.getTs());
            deviceParticularsVO.setSbpFigure(bp.getSbpFigure());
            deviceParticularsVO.setDbpFigure(bp.getDbpFigure());
            deviceParticularsVO.setMovingCount(other.getMovingCount());
        }
        if (resultsFatiguePubRhythm != null) {
            //节律图
            BigDecimal[] buffer = resultsFatiguePubRhythm.getBuffer();
            deviceParticularsVO.setBuffer(buffer);
        }
        if (resultBpPubFigure != null) {
            //呼吸波形
            Br br = resultBpPubFigure.getBr();
            BigDecimal[] brFigure = br.getBrFigure();
            deviceParticularsVO.setBrFigure(brFigure);
            //BCG波形|心冲击信号
            Hr hr = resultBpPubFigure.getHr();
            BigDecimal[] bcgFigure = hr.getBcgFigure();
            deviceParticularsVO.setBcgFigure(bcgFigure);

        }
        if (pubSummary != null) {
            //心率趋势
            BigDecimal[] bmpBuffer = pubSummary.getBmpBuffer();
            BigDecimal[] fatigueBuffer = pubSummary.getFatigueBuffer();
            deviceParticularsVO.setBmpBuffer(bmpBuffer);
            deviceParticularsVO.setFatigueBuffer(fatigueBuffer);
        }
        if (resultsFatiguePub.getCode().equals(1)&&resultsFatiguePub.getState().equals(1)){
            Integer score = resultsFatiguePub.getScore();
            deviceParticularsVO.setScore(score);
        }
        return deviceParticularsVO;
    }
}
