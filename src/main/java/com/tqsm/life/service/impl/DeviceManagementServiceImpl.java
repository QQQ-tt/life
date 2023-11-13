package com.tqsm.life.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tqsm.life.config.BaseEntity;
import com.tqsm.life.config.Constants;
import com.tqsm.life.config.exception.DataEnums;
import com.tqsm.life.config.exception.DataException;
import com.tqsm.life.entity.*;
import com.tqsm.life.interfaces.LifeClient;
import com.tqsm.life.mapper.life.AlarmSettingMapper;
import com.tqsm.life.mapper.life.DeviceManagementMapper;
import com.tqsm.life.mapper.life.DeviceUserMapper;
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
import com.tqsm.life.pojo.vo.DeviceExceptionAlertVO;
import com.tqsm.life.pojo.vo.DeviceManagementVO;
import com.tqsm.life.pojo.vo.DeviceParticularsVO;
import com.tqsm.life.pojo.vo.UserExceptionAlertVO;
import com.tqsm.life.service.*;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
        // TODO: 2023/11/10  
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

        IPage<DeviceManagementVO> deviceManagementVOIPage = baseMapper.selectPageNew(new Page<>(-1, -1),
                deviceManagementDTO);
        List<DeviceManagementVO> records = deviceManagementVOIPage.getRecords();
        if (!records.isEmpty()) {
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
        IPage<DeviceManagementVO> deviceManagementVOIPage = baseMapper.selectPageNew(new Page<>(-1, -1),
                deviceManagementDTO);
        List<DeviceManagementVO> records = deviceManagementVOIPage.getRecords();
        if (!records.isEmpty()) {
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
            //1跟0都测试连接成功
            if (code != null) {
                flag = true;
            }

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
                if (result.getHr() != null) {
                    if ((result.getHr() != 0 && result.getHr() <= alarmSetting.getHrLeft()) || (result.getHr() != 0 && result.getHr() >= alarmSetting.getHrRight())) {
                        alarmMontiorLog = new AlarmMontiorLog();
                        alarmMontiorLog.setDeviceCode(userId);
                        alarmMontiorLog.setMonitoringTime(LocalDateTime.now());
                        alarmMontiorLog.setExceptionItem("心率(bmp)");
                        alarmMontiorLog.setExceptionValue(result.getHr());
                        alarmMontiorLog.setReferenceInterval(alarmSetting.getHrLeft() + "-" + alarmSetting.getHrRight());
                        alarmMontiorLogService.saveOrUpdate(alarmMontiorLog);
                    }
                    deviceParticularsVO.setHr(result.getHr());
                }
                if (result.getBr() != null) {
                    if ((result.getBr() != 0 && result.getBr() <= alarmSetting.getBrLeft()) || (result.getBr() != 0 && result.getBr() >= alarmSetting.getBrRight())) {
                        alarmMontiorLog = new AlarmMontiorLog();
                        alarmMontiorLog.setDeviceCode(userId);
                        alarmMontiorLog.setMonitoringTime(LocalDateTime.now());
                        alarmMontiorLog.setExceptionItem("呼吸(bmp)");
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
                if (bp.getSbp() != null) {
                    if ((bp.getSbp() != 0 && bp.getSbp() <= alarmSetting.getSbpLeft()) || (bp.getSbp() != 0 && bp.getSbp() >= alarmSetting.getSbpRight())) {
                        deviceParticularsVO.setSbpException(1);
                        alarmMontiorLog = new AlarmMontiorLog();
                        alarmMontiorLog.setDeviceCode(userId);
                        alarmMontiorLog.setMonitoringTime(LocalDateTime.now());
                        alarmMontiorLog.setExceptionItem("收缩压(mmHg)");
                        alarmMontiorLog.setExceptionValue(bp.getSbp());
                        alarmMontiorLog.setReferenceInterval(alarmSetting.getSbpLeft() + "-" + alarmSetting.getSbpRight());
                        alarmMontiorLogService.saveOrUpdate(alarmMontiorLog);
                    }
                    deviceParticularsVO.setSbp(bp.getSbp());
                }
                if (bp.getDbp() != null) {
                    if ((bp.getDbp() != 0 && bp.getDbp() <= alarmSetting.getDbpLeft()) || (bp.getDbp() != 0 && bp.getDbp() >= alarmSetting.getDbpRight())) {
                        deviceParticularsVO.setSbpException(1);
                        alarmMontiorLog = new AlarmMontiorLog();
                        alarmMontiorLog.setDeviceCode(userId);
                        alarmMontiorLog.setMonitoringTime(LocalDateTime.now());
                        alarmMontiorLog.setExceptionItem("舒张压(mmHg)");
                        alarmMontiorLog.setExceptionValue(bp.getDbp());
                        alarmMontiorLog.setReferenceInterval(alarmSetting.getDbpLeft() + "-" + alarmSetting.getDbpRight());
                        alarmMontiorLogService.saveOrUpdate(alarmMontiorLog);
                    }
                    deviceParticularsVO.setDbp(bp.getDbp());
                }
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

    @Override
    public DeviceExceptionAlertVO exceptionAlert(String deviceCode) {
        DeviceExceptionAlertVO deviceExceptionAlertVO = new DeviceExceptionAlertVO();
        List<UserExceptionAlertVO> userExceptionAlertVOList = new ArrayList<>();
        UserExceptionAlertVO userExceptionAlertVO = null;
        //警报设置参数
        AlarmSetting alarmSetting = alarmSettingMapper.selectAlarm(deviceCode);
        if (alarmSetting == null) {
            throw new DataException(DataEnums.SETTING_ALERT);
        }
        int times = 0;
        //如果开启了定时,拿到时间
        Integer switches = alarmSetting.getSwitches();
        //开启定时弹窗
        if (switches == 0) {
            times = alarmSetting.getTims();
        }
        //默认弹窗关闭状态
        deviceExceptionAlertVO.setUpDown(Constants.DISABLE);
        deviceExceptionAlertVO.setTimes(times);
        ResultsBp resultsBp = lifeClient.bloodPressure(deviceCode);
        //根据设备编号查找绑定的用户体
        DeviceManagementVO deviceManagementVO = new DeviceManagementVO();
        DeviceManagementDTO deviceManagementDTO = new DeviceManagementDTO();
        deviceManagementDTO.setDeviceCode(deviceCode);
        IPage<DeviceManagementVO> deviceManagementVOIPage = baseMapper.selectPageNew(new Page<>(-1, -1),
                deviceManagementDTO);
        List<DeviceManagementVO> records = deviceManagementVOIPage.getRecords();
        if (!records.isEmpty()) {
            deviceManagementVO = records.get(0);
        }
        //copy用户信息体
        BeanUtils.copyProperties(deviceManagementVO, deviceExceptionAlertVO);
        if (resultsBp != null) {
            //血压计算结果
            Bp bp = resultsBp.getBp();
            Result result = resultsBp.getResult();
            if (result != null) {
                if (alarmSetting.getHrAlert().equals(Constants.ENABLE)) {
                    if (result.getHr() != null) {
                        if ((result.getHr() != 0 && result.getHr() <= alarmSetting.getHrLeft()) || (result.getHr() != 0 && result.getHr() >= alarmSetting.getHrRight())) {
                            userExceptionAlertVO = new UserExceptionAlertVO();
                            userExceptionAlertVO.setId(Constants.HR);
                            userExceptionAlertVO.setValue(result.getHr());
                            userExceptionAlertVO.setName("心率(次/分钟)");
                            userExceptionAlertVOList.add(userExceptionAlertVO);
                            deviceExceptionAlertVO.setUpDown(Constants.ENABLE);
                        }

                    }
                }
                if (alarmSetting.getBrAlert().equals(Constants.ENABLE)) {
                    if (result.getBr() != null) {
                        if ((result.getBr() != 0 && result.getBr() <= alarmSetting.getBrLeft()) || (result.getBr() != 0 && result.getBr() >= alarmSetting.getBrRight())) {
                            userExceptionAlertVO = new UserExceptionAlertVO();
                            userExceptionAlertVO.setId(Constants.BR);
                            userExceptionAlertVO.setValue(result.getBr());
                            userExceptionAlertVO.setName("呼吸(次/分钟)");
                            userExceptionAlertVOList.add(userExceptionAlertVO);
                            deviceExceptionAlertVO.setUpDown(Constants.ENABLE);
                        }
                    }
                }
            }
            if (bp != null) {
                if (alarmSetting.getBpAlert().equals(Constants.ENABLE)) {
                    if (bp.getSbp() != null) {
                        if ((bp.getSbp() != 0 && bp.getSbp() <= alarmSetting.getSbpLeft()) || (bp.getSbp() != 0 && bp.getSbp() >= alarmSetting.getSbpRight())) {
                            userExceptionAlertVO = new UserExceptionAlertVO();
                            userExceptionAlertVO.setId(Constants.SBP);
                            userExceptionAlertVO.setValue(bp.getSbp());
                            userExceptionAlertVO.setName("收缩压(mmHg)");
                            deviceExceptionAlertVO.setUpDown(Constants.ENABLE);
                        }

                    }
                    if (bp.getDbp() != null) {
                        if ((bp.getDbp() != 0 && bp.getDbp() <= alarmSetting.getDbpLeft()) || (bp.getDbp() != 0 && bp.getDbp() >= alarmSetting.getDbpRight())) {
                            userExceptionAlertVO = new UserExceptionAlertVO();
                            userExceptionAlertVO.setId(Constants.DBP);
                            userExceptionAlertVO.setValue(bp.getDbp());
                            userExceptionAlertVO.setName("舒张压(mmHg)");
                            deviceExceptionAlertVO.setUpDown(Constants.ENABLE);
                        }
                    }
                }
            }
            deviceExceptionAlertVO.setUserExceptionAlertVO(userExceptionAlertVOList);
        }
        return deviceExceptionAlertVO;
    }
}
