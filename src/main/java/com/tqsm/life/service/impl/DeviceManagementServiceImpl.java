package com.tqsm.life.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tqsm.life.config.BaseEntity;
import com.tqsm.life.config.exception.DataEnums;
import com.tqsm.life.config.exception.DataException;
import com.tqsm.life.entity.*;
import com.tqsm.life.interfaces.LifeClient;
import com.tqsm.life.mapper.AlarmSettingMapper;
import com.tqsm.life.mapper.DeviceManagementMapper;
import com.tqsm.life.mapper.DeviceUserMapper;
import com.tqsm.life.pojo.dto.DeviceManagementDTO;
import com.tqsm.life.pojo.life.PersonState;
import com.tqsm.life.pojo.life.result.bp.Bp;
import com.tqsm.life.pojo.life.result.bp.Exception;
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
import com.tqsm.life.service.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    @Resource
    private AlarmSettingMapper alarmSettingMapper;

    @Resource
    private AlarmMontiorLogService alarmMontiorLogService;

    @Resource
    private DeviceUserMapper deviceUserMapper;

    public DeviceManagementServiceImpl(DeviceUserService deviceUserService,
                                       DeviceMonitorLogService deviceMonitorLogService,
                                       DeviceHeartbeatService deviceHeartbeatService, LifeClient lifeClient) {
        this.deviceUserService = deviceUserService;
        this.deviceMonitorLogService = deviceMonitorLogService;
        this.deviceHeartbeatService = deviceHeartbeatService;
        this.lifeClient = lifeClient;
    }

    @Override
    public IPage<DeviceManagementVO> listDevice(DeviceManagementDTO dto) {
        IPage<DeviceManagementVO> deviceManagementVOIPage = baseMapper.selectPageNew(dto.getPage(), dto);
        // TODO: 2023/11/3 造的假数据，记得删除
        List<DeviceManagementVO> records = deviceManagementVOIPage.getRecords();
        DeviceManagementVO deviceManagement = new DeviceManagementVO();
        deviceManagement.setDeviceCode("17003f000c504b4b48353420");
        deviceManagement.setDeviceName("设备2");
        deviceManagement.setId("2");
        deviceManagement.setDeviceUserId(17);
        deviceManagement.setName("崔卜文");
        deviceManagement.setSex(0);
        deviceManagement.setIdCard("320586199906301211");
        deviceManagement.setTel("15248525256");
        deviceManagement.setAge(24);
        deviceManagement.setPerson(true);
        deviceManagement.setOnline(true);
        deviceManagement.setMonitoring(true);
        records.add(deviceManagement);
        DeviceManagementVO deviceManagement2 = new DeviceManagementVO();
        deviceManagement2.setDeviceCode("290026676756756756756");
        deviceManagement2.setDeviceName("设备3");
        deviceManagement2.setId("3");
        deviceManagement2.setDeviceUserId(18);
        deviceManagement2.setName("范佳丽");
        deviceManagement2.setSex(0);
        deviceManagement2.setIdCard("320586199307301211");
        deviceManagement2.setTel("15252512546");
        deviceManagement2.setAge(24);
        deviceManagement2.setPerson(true);
        deviceManagement2.setOnline(true);
        deviceManagement2.setMonitoring(true);
        records.add(deviceManagement2);
        deviceManagementVOIPage.setRecords(records);
        return deviceManagementVOIPage;
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
                .ne(deviceManagement.getId() != null, BaseEntity::getId, deviceManagement.getId()));
        if (count < 1) {
            return saveOrUpdate(deviceManagement);
        } else {
            throw new DataException(DataEnums.DATA_REPEAT);
        }
    }

    @Override
    @Transactional
    public DeviceManagementVO bindThePatient(int deviceId, int userId) {
        DeviceManagementVO deviceManagementVO = new DeviceManagementVO();
        DeviceManagementDTO deviceManagementDTO = new DeviceManagementDTO();
        deviceManagementDTO.setDeviceId(deviceId);
        deviceUserService.update(Wrappers.lambdaUpdate(DeviceUser.class)
                .eq(DeviceUser::getDeviceId, deviceId)
                .set(DeviceUser::getIsHis, Boolean.TRUE));
        deviceUserService.save(DeviceUser.builder().deviceId(deviceId).userId(userId).build());

        IPage<DeviceManagementVO> deviceManagementVOIPage = baseMapper.selectPageNew(new Page<>(-1,-1),
                deviceManagementDTO);
        List<DeviceManagementVO> records = deviceManagementVOIPage.getRecords();
        if (!records.isEmpty()){
             deviceManagementVO = records.get(0);
        }
        return deviceManagementVO;
    }

    @Override
    @Transactional
    public DeviceManagementVO relieveThePatient(int deviceId) {
        DeviceManagementVO deviceManagementVO = new DeviceManagementVO();
        DeviceManagementDTO deviceManagementDTO = new DeviceManagementDTO();
        deviceManagementDTO.setDeviceId(deviceId);
        deviceUserService.update(Wrappers.lambdaUpdate(DeviceUser.class)
                .eq(DeviceUser::getDeviceId, deviceId)
                .set(DeviceUser::getIsHis, Boolean.TRUE));
        IPage<DeviceManagementVO> deviceManagementVOIPage = baseMapper.selectPageNew(new Page<>(-1,-1),
                deviceManagementDTO);
        List<DeviceManagementVO> records = deviceManagementVOIPage.getRecords();
        if (!records.isEmpty()){
            deviceManagementVO = records.get(0);
        }
        return deviceManagementVO;
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
        boolean remove = remove(Wrappers.lambdaQuery(DeviceManagement.class).eq(BaseEntity::getId, deviceId));
        List<DeviceUser> list = deviceUserService.list(Wrappers.lambdaQuery(DeviceUser.class)
                .eq(DeviceUser::getDeviceId, deviceId));
        deviceUserService.remove(Wrappers.lambdaUpdate(DeviceUser.class).eq(DeviceUser::getDeviceId, deviceId));
        deviceMonitorLogService.removeBatchByIds(list.stream().map(BaseEntity::getId).collect(Collectors.toList()));
        deviceHeartbeatService.remove(Wrappers.lambdaUpdate(DeviceHeartbeat.class)
                .eq(DeviceHeartbeat::getDeviceId, deviceId));
        return remove;
    }

    @Override
    @Transactional
    public DeviceParticularsVO particulars(String userId) {
        DeviceParticularsVO deviceParticularsVO = new DeviceParticularsVO();
        AlarmMontiorLog alarmMontiorLog = null;
        ResultsBp resultsBp = lifeClient.bloodPressure(userId);
        ResultsFatiguePubRhythm resultsFatiguePubRhythm = lifeClient.fatiguePubRhythm(userId);
        ResultBpPubFigure resultBpPubFigure = lifeClient.bloodPressurePubFigure(userId);
        PubSummary pubSummary = lifeClient.fatiguePubSummary(userId);
        ResultsFatiguePub resultsFatiguePub = lifeClient.fatiguePub(userId);
        //警报设置参数
        AlarmSetting alarmSetting = alarmSettingMapper.selectAlarm(userId);
        if (resultsBp != null) {
            //血压计算结果
            Bp bp = resultsBp.getBp();
            Result result = resultsBp.getResult();
            Other other = resultsBp.getOther();
            Exception exception = resultsBp.getException();
            if (result != null) {
                if (result.getHr()!=null){
                    if ((result.getHr() != 0 && result.getHr() <= alarmSetting.getHrLeft()) || (result.getHr() != 0 && result.getHr() >= alarmSetting.getHrRight())) {
                        alarmMontiorLog = new AlarmMontiorLog();
                        alarmMontiorLog.setDeviceCode(userId);
                        alarmMontiorLog.setMonitoringTime(LocalDateTime.now());
                        alarmMontiorLog.setExceptionItem("心率(hr)异常");
                        alarmMontiorLog.setExceptionValue(result.getHr());
                        alarmMontiorLog.setReferenceInterval(alarmSetting.getHrLeft() + "-" + alarmSetting.getHrRight());
                        alarmMontiorLogService.saveOrUpdate(alarmMontiorLog);
                    }
                    deviceParticularsVO.setHr(result.getHr());
                }
               if (result.getBr()!=null){
                   if ((result.getBr() != 0 && result.getBr() <= alarmSetting.getBrLeft()) || (result.getBr() != 0 && result.getBr() >= alarmSetting.getBrRight())) {
                       alarmMontiorLog = new AlarmMontiorLog();
                       alarmMontiorLog.setDeviceCode(userId);
                       alarmMontiorLog.setMonitoringTime(LocalDateTime.now());
                       alarmMontiorLog.setExceptionItem("呼吸(Br)异常");
                       alarmMontiorLog.setExceptionValue(result.getBr());
                       alarmMontiorLog.setReferenceInterval(alarmSetting.getBrLeft() + "-" + alarmSetting.getBrRight());
                       alarmMontiorLogService.saveOrUpdate(alarmMontiorLog);
                   }
                   deviceParticularsVO.setBr(result.getBr());
               }
            }
            if (bp != null) {
                deviceParticularsVO.setSbpException(0);
                deviceParticularsVO.setDbpException(0);
                if (((bp.getSbp() != 0 && bp.getSbp() <= alarmSetting.getSbpLeft())&&bp.getSbp()!=null) || ((bp.getSbp() != 0 && bp.getSbp() >= alarmSetting.getSbpRight())&&bp.getSbp()!=null)) {
                    deviceParticularsVO.setSbpException(1);
                    alarmMontiorLog = new AlarmMontiorLog();
                    alarmMontiorLog.setDeviceCode(userId);
                    alarmMontiorLog.setMonitoringTime(LocalDateTime.now());
                    alarmMontiorLog.setExceptionItem("收缩压(sbp)异常");
                    alarmMontiorLog.setExceptionValue(bp.getSbp());
                    alarmMontiorLog.setReferenceInterval(alarmSetting.getSbpLeft() + "-" + alarmSetting.getSbpRight());
                    alarmMontiorLogService.saveOrUpdate(alarmMontiorLog);
                }
                if (((bp.getDbp() != 0 && bp.getDbp() <= alarmSetting.getDbpLeft())&&bp.getDbp()!=null) || ((bp.getDbp() != 0 && bp.getDbp() >= alarmSetting.getDbpRight()))&&bp.getDbp()!=null) {
                    deviceParticularsVO.setSbpException(1);
                    alarmMontiorLog = new AlarmMontiorLog();
                    alarmMontiorLog.setDeviceCode(userId);
                    alarmMontiorLog.setMonitoringTime(LocalDateTime.now());
                    alarmMontiorLog.setExceptionItem("舒张压(dbp)异常");
                    alarmMontiorLog.setExceptionValue(bp.getDbp());
                    alarmMontiorLog.setReferenceInterval(alarmSetting.getDbpLeft() + "-" + alarmSetting.getDbpRight());
                    alarmMontiorLogService.saveOrUpdate(alarmMontiorLog);
                }
                deviceParticularsVO.setSbp(bp.getSbp());
                deviceParticularsVO.setDbp(bp.getDbp());
                deviceParticularsVO.setTs(bp.getTs());
                deviceParticularsVO.setSbpFigure(bp.getSbpFigure());
                deviceParticularsVO.setDbpFigure(bp.getDbpFigure());
            }
            if (other != null) {
                deviceParticularsVO.setMovingCount(other.getMovingCount());
            }
            if (exception != null) {
                deviceParticularsVO.setHrException(exception.getHrException());
                deviceParticularsVO.setBrException(exception.getBrException());
                deviceParticularsVO.setMoveException(exception.getMoveException());
                deviceParticularsVO.setResultException(exception.getResultException());
            }

        }
        if (resultsFatiguePubRhythm != null) {
            //节律图
            BigDecimal[] buffer = resultsFatiguePubRhythm.getBuffer();
            if (buffer != null) {
                deviceParticularsVO.setBuffer(buffer);
            }
        }
        if (resultBpPubFigure != null) {
            //呼吸波形
            Br br = resultBpPubFigure.getBr();
            if (br != null) {
                BigDecimal[] brFigure = br.getBrFigure();
                deviceParticularsVO.setBrFigure(brFigure);
            }
            //BCG波形|心冲击信号  ECG波形|心电信号
            Hr hr = resultBpPubFigure.getHr();
            if (hr != null) {
                BigDecimal[] bcgFigure = hr.getBcgFigure();
                BigDecimal[] ecgFigure = hr.getEcgFigure();
                deviceParticularsVO.setEcgFigure(ecgFigure);
                deviceParticularsVO.setBcgFigure(bcgFigure);
            }
        }
        if (pubSummary != null) {
            //心率趋势
            BigDecimal[] bmpBuffer = pubSummary.getBmpBuffer();
            if (bmpBuffer != null) {
                BigDecimal[] fatigueBuffer = pubSummary.getFatigueBuffer();
                deviceParticularsVO.setBmpBuffer(bmpBuffer);
                deviceParticularsVO.setFatigueBuffer(fatigueBuffer);
            }
        }
        if (resultsFatiguePub.getCode().equals(1) && resultsFatiguePub.getState().equals(1)) {
            Integer score = resultsFatiguePub.getScore();
            deviceParticularsVO.setScore(score);
        }
        return deviceParticularsVO;
    }
}
