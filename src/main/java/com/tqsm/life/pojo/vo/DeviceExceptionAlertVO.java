package com.tqsm.life.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author xnd
 * @since 2023/11/8 15:15
 */
@Data
public class DeviceExceptionAlertVO {

    @Schema(description = "设备名称")
    private String deviceName;

    @Schema(description = "患者姓名")
    private String name;

    @Schema(description = "年龄（岁）")
    private Integer age;

    @Schema(description = "性别（女：0 男：1）")
    private Integer sex;

    @Schema(description = "弹窗时间")
    private Integer times;

    @Schema(description = "是否弹窗  0弹 1不弹")
    private Integer upDown;

    @Schema(description = "信息体")
    private List<UserExceptionAlertVO> userExceptionAlertVO;
}
