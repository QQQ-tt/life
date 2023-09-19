package com.tqsm.life.pojo.life.result.cache;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author xnd
 * @since 2023/8/29 17:44
 */
@Data
public class ResultCache {

    private Integer code;

    private Integer length;

    private String id;

    private String message;

    private List<datas> datas;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("device_id")
    private String deviceId;
}
