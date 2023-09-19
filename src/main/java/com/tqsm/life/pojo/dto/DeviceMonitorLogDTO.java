package com.tqsm.life.pojo.dto;

import com.tqsm.life.config.PageDTO;
import com.tqsm.life.entity.DeviceMonitorLog;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xnd
 * @since 2023/9/7 11:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeviceMonitorLogDTO extends PageDTO<DeviceMonitorLog> {

    @Schema(description = "监测人员列表id")
    private Integer deviceUserId;
}
