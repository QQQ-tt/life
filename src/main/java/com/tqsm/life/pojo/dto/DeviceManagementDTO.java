package com.tqsm.life.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author qtx
 * @since 2023/9/1
 */
@Data
public class DeviceManagementDTO {

    /**
     * 设备名称
     */
    @Schema(description = "设备名称")
    private String deviceName;

    /**
     * 设备编号
     */
    @Schema(description = "设备编号")
    private String deviceCode;

    /**
     * 是否有人在床
     */
    @Schema(description = "是否有人在床")
    private Boolean state;
}
