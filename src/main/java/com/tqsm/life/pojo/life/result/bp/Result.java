package com.tqsm.life.pojo.life.result.bp;

import lombok.Data;

/**
 * @author qtx
 * @since 2023/8/24
 */
@Data
public class Result {
    /**
     * hr: 心率值，单位: 次/分钟
     */
    private  Integer hr;

    /**
     * br: 呼吸值，单位: 次/分钟
     */
    private  Integer br;

}
