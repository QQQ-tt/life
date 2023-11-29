package com.tqsm.life.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xnd
 * @since 2023/9/7 10:23
 */
@Data
public class DeviceUserPageVO {

    @Schema(description = "id")
    private Integer id;

    @Schema(description = "患者姓名")
    private String name;

    @Schema(description = "年龄（岁）")
    private Integer age;

    @Schema(description = "性别（女：0 男：1）")
    private Integer sex;

    @Schema(description = "身份证号")
    private String idCard;

    @Schema(description = "手机号")
    private String tel;

    @Schema(description = "设备名称")
    private String deviceName;

    @Schema(description = "设备编号")
    private String deviceCode;

    @Schema(description = "绑定时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createOn;
}
