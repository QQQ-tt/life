package com.tqsm.life.pojo.dto;

import com.tqsm.life.config.PageDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/9/7 10:28
 */
@Data
public class DeviceUserPageDTO extends PageDTO {

    @Schema(description = "患者姓名")
    private String name;

    @Schema(description = "身份证号")
    private String idCard;

    @Schema(description = "性别（女：0 男：1）")
    private Integer sex;

    @Schema(description = "设备名称")
    private String deviceName;

    @Schema(description = "设备编号")
    private String deviceCode;
}
