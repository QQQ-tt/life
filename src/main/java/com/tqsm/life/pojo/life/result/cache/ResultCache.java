package com.tqsm.life.pojo.life.result.cache;

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

    private List<datas> datasList;

    private Integer userId;

    private String deviceId;
}
