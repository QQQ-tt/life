package com.tqsm.life.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author xnd
 * @since 2023/10/23 16:26
 */
@Data
public class HistoricalParticularsVO {

    /**
     * 有人/无人状态信息。其中：0 无人，1 有人
     */
    private Integer state;

    /**
     * hr：心率值
     */
    private List<Integer> hr;

    /**
     * br：呼吸值
     */
    private List<Integer> br;

    /**
     * sbp：收缩压
     */
    private List<Integer> sbp;

    /**
     * dbp：舒张压
     */
    private List<Integer> dbp;

    /**
     * moving_count：体动值。
     */
    @JsonProperty("moving_count")
    private List<Integer> movingCount;
}
