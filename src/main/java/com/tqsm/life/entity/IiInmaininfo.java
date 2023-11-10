package com.tqsm.life.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * II_住院主表
 * </p>
 *
 * @author xnd
 * @since 2023-11-10
 */
@Data
@TableName("II_INMAININFO")
public class IiInmaininfo {

    /**
     * 住院流水号
     */
    @TableId("INPATIENT_NO")
    private String inpatientNo;

    /**
     * 住院号
     */
    @TableField("PATIENT_NO")
    private String patientNo;

    /**
     * 病历号
     */
    @TableField("CARD_NO")
    private String cardNo;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 性别
     */
    @TableField("SEX")
    private String sex;

    /**
     * 出生日期
     */
    @TableField("BIRTHDAY")
    private LocalDateTime birthday;

    /**
     * 身高
     */
    @TableField("HEIGHT")
    private BigDecimal height;

    /**
     * 体重
     */
    @TableField("WEIGHT")
    private BigDecimal weight;

    /**
     * 血型编码
     */
    @TableField("BLOOD_CODE")
    private String bloodCode;

    /**
     * Y:有  N:无
     */
    @TableField("HEPATITIS_FLAG")
    private String hepatitisFlag;

    /**
     * Y:有  N:无
     */
    @TableField("ANAPHY_FLAG")
    private String anaphyFlag;

    /**
     * 入院日期
     */
    @TableField("IN_DATE")
    private LocalDateTime inDate;

    /**
     * 科室代码
     */
    @TableField("DEPT_CODE")
    private String deptCode;

    /**
     * 科室名称
     */
    @TableField("DEPT_NAME")
    private String deptName;

    /**
     * 大科代码
     */
    @TableField("SDEPT_CODE")
    private String sdeptCode;

    /**
     * 大科名称
     */
    @TableField("SDEPT_NAME")
    private String sdeptName;

    /**
     * 01-自费  02-保险 03-公费在职 04-公费退休 05-公费高干
     */
    @TableField("PAYKIND_CODE")
    private String paykindCode;

    /**
     * 合同代码，0自费，99国家医保，1苏州医保
     */
    @TableField("PACT_CODE")
    private String pactCode;

    /**
     * 合同单位名称，自费、国家医保、苏州医保等
     */
    @TableField("PACT_NAME")
    private String pactName;

    /**
     * 折扣比率
     */
    @TableField("REBATE_RATE")
    private Short rebateRate;

    /**
     * 病床号
     */
    @TableField("BED_NO")
    private String bedNo;

    /**
     * 护理单元代码
     */
    @TableField("NURSE_CELL_CODE")
    private String nurseCellCode;

    /**
     * 护理单元名称
     */
    @TableField("NURSE_CELL_NAME")
    private String nurseCellName;

    /**
     * 医师代码(住院)
     */
    @TableField("HOUSE_DOC_CODE")
    private String houseDocCode;

    /**
     * 医师姓名(住院)
     */
    @TableField("HOUSE_DOC_NAME")
    private String houseDocName;

    /**
     * 医师代码(主治)
     */
    @TableField("CHARGE_DOC_CODE")
    private String chargeDocCode;

    /**
     * 医师姓名(主治)
     */
    @TableField("CHARGE_DOC_NAME")
    private String chargeDocName;

    /**
     * 医师代码(主任)
     */
    @TableField("CHIEF_DOC_CODE")
    private String chiefDocCode;

    /**
     * 医师姓名(主任)
     */
    @TableField("CHIEF_DOC_NAME")
    private String chiefDocName;

    /**
     * 护士代码(责任)
     */
    @TableField("DUTY_NURSE_CODE")
    private String dutyNurseCode;

    /**
     * 护士姓名(责任)
     */
    @TableField("DUTY_NURSE_NAME")
    private String dutyNurseName;

    /**
     * 操作时间(最新)
     */
    @TableField("OPER_DTIME")
    private LocalDateTime operDtime;

    /**
     * 操作员代码
     */
    @TableField("OPER_CODE")
    private String operCode;

    /**
     * 入院情况
     */
    @TableField("IN_CIRCS")
    private String inCircs;

    /**
     * 入院途径 1 门诊 2 急诊
     */
    @TableField("IN_AVENUE")
    private String inAvenue;

    /**
     * 1:门诊，2:急诊，3:转科，4:转院
     */
    @TableField("IN_SOURCE")
    private String inSource;

    /**
     * 住院次数
     */
    @TableField("IN_TIMES")
    private Short inTimes;

    /**
     * 终止日期(汇总)
     */
    @TableField("END_DATE")
    private LocalDateTime endDate;

    /**
     * 结算日期(上次)
     */
    @TableField("BALANCE_DATE")
    private LocalDateTime balanceDate;

    /**
     * 预交金额(未结)
     */
    @TableField("PREPAY_COST")
    private BigDecimal prepayCost;

    /**
     * 费用金额(未结)
     */
    @TableField("TOT_COST")
    private BigDecimal totCost;

    /**
     * 自费金额(未结)
     */
    @TableField("OWN_COST")
    private BigDecimal ownCost;

    /**
     * 自付金额(未结)
     */
    @TableField("PAY_COST")
    private BigDecimal payCost;

    /**
     * 公费金额(未结)
     */
    @TableField("PUB_COST")
    private BigDecimal pubCost;

    /**
     * 余额(未结)
     */
    @TableField("FREE_COST")
    private BigDecimal freeCost;

    /**
     * 1:有婴儿；0:无婴儿
     */
    @TableField("BABY_FLAG")
    private String babyFlag;

    /**
     * Y:是查询费用减免表；N:没有减免
     */
    @TableField("DERATE_FLAG")
    private String derateFlag;

    /**
     * 最新医嘱日期
     */
    @TableField("DOC_ADVICEDATE")
    private LocalDateTime docAdvicedate;

    /**
     * 1-住院登记  2-病房接诊 3-出院登记 4-出院结算 5-预约出院,6-无费退院
     */
    @TableField("IN_STATE")
    private String inState;

    /**
     * 出院日期(预约)
     */
    @TableField("PREPAY_OUTDATE")
    private LocalDateTime prepayOutdate;

    /**
     * 发生序号
     */
    @TableField("HAPPEN_NO")
    private Integer happenNo;

    /**
     * 结算序号
     */
    @TableField("BALANCE_NO")
    private Short balanceNo;

    /**
     * 身份证号
     */
    @TableField("IDENNO")
    private String idenno;

    /**
     * 职业代码
     */
    @TableField("PROF_CODE")
    private String profCode;

    /**
     * 工作单位
     */
    @TableField("WORK_NAME")
    private String workName;

    /**
     * 单位电话
     */
    @TableField("WORK_TEL")
    private String workTel;

    /**
     * 单位邮编
     */
    @TableField("WORK_ZIP")
    private String workZip;

    /**
     * 户口或家庭地址
     */
    @TableField("HOME")
    private String home;

    /**
     * 家庭电话
     */
    @TableField("HOME_TEL")
    private String homeTel;

    /**
     * 户口或家庭邮编
     */
    @TableField("HOME_ZIP")
    private String homeZip;

    /**
     * 籍贯
     */
    @TableField("DIST")
    private String dist;

    /**
     * 出生地代码
     */
    @TableField("BIRTH_AREA")
    private String birthArea;

    /**
     * 民族
     */
    @TableField("NATION_CODE")
    private String nationCode;

    /**
     * 联系人姓名
     */
    @TableField("LINKMA_NAME")
    private String linkmaName;

    /**
     * 联系人电话
     */
    @TableField("LINKMAN_TEL")
    private String linkmanTel;

    /**
     * 联系人住址
     */
    @TableField("LINKMAN_ADD")
    private String linkmanAdd;

    /**
     * 联系人关系
     */
    @TableField("RELA_CODE")
    private String relaCode;

    /**
     * 婚姻状况
     */
    @TableField("MARI")
    private String mari;

    /**
     * 国籍
     */
    @TableField("COUN_CODE")
    private String counCode;

    /**
     * 重患标志
     */
    @TableField("PERSONAGE_FLAG")
    private String personageFlag;

    /**
     * 血压
     */
    @TableField("XY")
    private String xy;

    /**
     * 医疗证号
     */
    @TableField("MCARD_NO")
    private String mcardNo;

    /**
     * 是否关帐
     */
    @TableField("STOP_ACOUNT")
    private String stopAcount;

    /**
     * 出院日期
     */
    @TableField("OUT_DATE")
    private LocalDateTime outDate;

    /**
     * 服装押金
     */
    @TableField("DRESS_DEPOSIT")
    private BigDecimal dressDeposit;

    /**
     * 服装号
     */
    @TableField("DRESS_NO")
    private String dressNo;

    /**
     * 转归代号
     */
    @TableField("ZG")
    private String zg;

    /**
     * 担保人代码
     */
    @TableField("CAUTIONER")
    private String cautioner;

    /**
     * 担保金额
     */
    @TableField("MONEY")
    private BigDecimal money;

    /**
     * 1:有病历，0:无病历
     */
    @TableField("CASE_FLAG")
    private String caseFlag;

    /**
     * 警戒线
     */
    @TableField("MONEY_ALERT")
    private BigDecimal moneyAlert;

    @TableField("EMPL_CODE")
    private String emplCode;

    @TableField("MEDICAL_TYPE")
    private String medicalType;

    /**
     * 减免金额
     */
    @TableField("DERATE_COST")
    private BigDecimal derateCost;

    /**
     * 预交金额(已结)
     */
    @TableField("BALANCE_PREPAY")
    private BigDecimal balancePrepay;

    /**
     * 费用金额(已结)
     */
    @TableField("BALANCE_COST")
    private BigDecimal balanceCost;

    /**
     * 是否在ICU 0 no 1 yes
     */
    @TableField("IN_ICU")
    private String inIcu;

    /**
     * 实习医生代码
     */
    @TableField("PRACTICE_DOC_CODE")
    private String practiceDocCode;

    /**
     * 实习医生姓名
     */
    @TableField("PRACTICE_DOC_NAME")
    private String practiceDocName;

    /**
     * 进修医生代码
     */
    @TableField("NOVICIATE_DOC_CODE")
    private String noviciateDocCode;

    /**
     * 进修医生姓名
     */
    @TableField("NOVICIATE_DOC_NAME")
    private String noviciateDocName;

    @TableField("CONVOY_NRS_CODE")
    private String convoyNrsCode;

    @TableField("CONVOY_NRS_NAME")
    private String convoyNrsName;

    @TableField("CONVOY_TOOL_CODE")
    private String convoyToolCode;

    @TableField("CONVOY_TOOL_NAME")
    private String convoyToolName;

    /**
     * 大额补助
     */
    @TableField("DEBZ_COST")
    private BigDecimal debzCost;

    /**
     * 公务员
     */
    @TableField("GWY_COST")
    private BigDecimal gwyCost;

    @TableField("IF_ACCOMPANY")
    private String ifAccompany;

    /**
     * 拼音码
     */
    @TableField("PY")
    private String py;

    /**
     * 科主任代码
     */
    @TableField("DIRECTOR_CODE")
    private String directorCode;

    /**
     * 科主任名称
     */
    @TableField("DIRECTOR_NAME")
    private String directorName;

    /**
     * 病案送入病案室否0未1送
     */
    @TableField("CASE_SENDFLAG")
    private String caseSendflag;

    /**
     * 转科标志
     */
    @TableField("CHANGE_DEPT")
    private String changeDept;

    @TableField("REMARK")
    private String remark;

    @TableField("CHECK_FLAG")
    private String checkFlag;

    /**
     * 省医保回传的流水号（南京省医保专用）
     */
    @TableField("SI_ENREG_NO")
    private String siEnregNo;

    /**
     * 出院小结打印标记0未打印，1已打印
     */
    @TableField("OUTRECORD_PRINTFLAG")
    private String outrecordPrintflag;

    /**
     * 医保上传号
     */
    @TableField("SI_TRANSNO")
    private String siTransno;

    /**
     * 医保卡信息(预结算使用)
     */
    @TableField("SI_CARDINFO")
    private String siCardinfo;

    /**
     * 患者的医嘱信息转移标志 come from zxs
     */
    @TableField("TRANS_FLAG")
    private String transFlag;

    /**
     * 患者饮食状况
     */
    @TableField("FOOD_STATE")
    private String foodState;

    /**
     * 欠费额度(苏州添加)
     */
    @TableField("LACK_STANDARD")
    private BigDecimal lackStandard;

    /**
     * 是否设置个人欠费额度标记(0 跟病区、科室设置欠费额度一致 1单独为个人设置)
     */
    @TableField("YN_PERSON_LACK")
    private String ynPersonLack;

    /**
     * 院内住院号(病案号)，可修改（苏州专用）
     */
    @TableField("PATIENT_NO_SZ")
    private String patientNoSz;

    /**
     * 老病人标志
     */
    @TableField("OLD_BR")
    private String oldBr;

    /**
     * 园区医保的交易号字段长，新增加
     */
    @TableField("SI_TRANSNO_YQ")
    private String siTransnoYq;

    /**
     * 生育类型
     */
    @TableField("SY_KIND")
    private String syKind;

    /**
     * 生育证号
     */
    @TableField("SY_ZH")
    private String syZh;

    /**
     * 生育日期
     */
    @TableField("SY_DATE")
    private LocalDateTime syDate;

    /**
     * 生育项目
     */
    @TableField("SY_FWXM")
    private String syFwxm;

    /**
     * 生育类别
     */
    @TableField("SY_SYLX")
    private String sySylx;

    @TableField("UPLOADCYINFO")
    private String uploadcyinfo;

    @TableField("UPLOADCYINFO_DATE")
    private LocalDateTime uploadcyinfoDate;

    /**
     * 热量
     */
    @TableField("ENERGY")
    private String energy;

    /**
     * 结算时用，用于控制医保分离关联
     */
    @TableField("CON_NUM")
    private Integer conNum;

    /**
     * 特殊上传控制标记
     */
    @TableField("UP_CONTROL")
    private String upControl;

    /**
     * 随访病人
     */
    @TableField("SF_FLAG")
    private String sfFlag;

    /**
     * 生育胎数
     */
    @TableField("SY_TS")
    private Short syTs;

    /**
     * 生育并发症
     */
    @TableField("SY_BFZ")
    private String syBfz;

    /**
     * 医疗组长代码
     */
    @TableField("YLZZ_CODE")
    private String ylzzCode;

    /**
     * 医疗组长名称
     */
    @TableField("YLZZ_NAME")
    private String ylzzName;

    /**
     * 病人照片add by yux 2012-7-19
     */
    @TableField("PHOTO")
    private byte[] photo;

    /**
     * 社会保障卡号
     */
    @TableField("BAOZHANGCARDNO")
    private String baozhangcardno;

    /**
     * 住院登记ID
     */
    @TableField("ZYDJID")
    private String zydjid;

    /**
     * 医疗就诊事件ID
     */
    @TableField("YLJZSJID")
    private String yljzsjid;

    /**
     * 往年账户冲自负标志
     */
    @TableField("WNZHFLAG")
    private String wnzhflag;

    /**
     * 参保地行政区划代码
     */
    @TableField("AREA_FLAG")
    private String areaFlag;

    /**
     * 欠费冻结标识 0未冻结 1 冻结 yux 2012-12-12
     */
    @TableField("FROSEN_FLAG")
    private String frosenFlag;

    /**
     * 是否日间手术患者标记 0 否 1 是
     */
    @TableField("YN_RJSX")
    private String ynRjsx;

    /**
     * 挂号单的处方号
     */
    @TableField("CLINIC_CODE")
    private String clinicCode;

    /**
     * 园区 明细交易唯一号 
     */
    @TableField("BLUNIQSN")
    private String bluniqsn;

    @TableField("ADR1_PROVINCE")
    private String adr1Province;

    @TableField("ADR2_CITY")
    private String adr2City;

    @TableField("ADR3_TOWN")
    private String adr3Town;

    @TableField("ADR4_QT")
    private String adr4Qt;

    /**
     * 血型RH：阴性、阳性，20190212，胡思聪
     */
    @TableField("BLOOD_RH")
    private String bloodRh;

    /**
     * 20190904 园区生育-新生儿生存状态 1-存活；0-死亡
     */
    @TableField("SY_XSESCZT")
    private String syXsesczt;

    /**
     * 病人标签：1日间手术、2院前准备、3疑似新冠
     */
    @TableField("PATIENT_TAG")
    private String patientTag;

    /**
     * 0-否 ， 1-是 。。。默认为否
     */
    @TableField("YN_VIP")
    private String ynVip;

    /**
     * 出院备注，允许为空
     */
    @TableField("OUT_REMARK")
    private String outRemark;

    /**
     * 青海的异地病人mcard_no升级为50位
     */
    @TableField("MCARD_NO_NEW")
    private String mcardNoNew;

    /**
     * 患者类别，如VIP，用于控制查看权限分类，20210827胡思聪
     */
    @TableField("PATIENT_KIND")
    private String patientKind;

    /**
     * add  by  wy  存储病人DRGS审核状态
     */
    @TableField("DRGSINFO")
    private String drgsinfo;

    /**
     * add  by  wy  存储病人DRGS审核明细
     */
    @TableField("DRGSINFO_DETAIL")
    private String drgsinfoDetail;
}
