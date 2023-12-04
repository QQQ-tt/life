package com.tqsm.life.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/11/8 16:47
 */
@Data
public class DeviceAlertDTO {

    /**
     * 设备id
     */
    @Schema(description = "设备id")
    private Integer deviceId;

    /**
     * 警报类型
     */
    @Schema(description = "1是血压,2是心电图,3是呼吸波")
    private Integer type;

    /**
     * 警报类型
     */
    @Schema(description = "开启状态(0:开启，1:关闭)")
    private Integer able;
}
