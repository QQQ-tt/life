package com.tqsm.life.pojo.life.result.bp.figure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/8/29 15:44
 */
@Data
public class Weight {

    private Integer code;

    @JsonProperty("default")
    private Integer default1;

    private Integer realtime;
}
