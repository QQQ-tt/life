package com.tqsm.life.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author qtx
 * @since 2023/9/1
 */
@Data
public class DeviceManagementVO {

    @Schema(description = "设备id")
    private String id;

    @Schema(description = "设备编码")
    private String deviceCode;

    @Schema(description = "设备名称")
    private String deviceName;

    @Schema(description = "设备用户关联id")
    private Integer deviceUserId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "性别编号")
    private Integer sex;

    @Schema(description = "身份证")
    private String idCard;

    @Schema(description = "电话")
    private String tel;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "有人无人")
    private Boolean person;

    @Schema(description = "是否在线")
    private Boolean online;
}
