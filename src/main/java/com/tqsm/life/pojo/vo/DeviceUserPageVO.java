package com.tqsm.life.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

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
}
