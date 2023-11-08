package com.tqsm.life.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/11/8 15:35
 */
@Data
public class UserExceptionAlertVO {

    @Schema(description = "警报项")
    private String name;

    @Schema(description = "警报值")
    private Integer value;
}
