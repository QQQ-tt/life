package com.tqsm.life.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xnd
 * @since 2023/9/14 15:28
 */
@Data
public class DeviceParticularsVO {

    /**
     * 疲劳计算结果
     */
    @Schema(description = "疲劳值")
    private Integer score;

    /**
     * 血压计算结果
     */

    @Schema(description = "心率")
    private Integer hr;

    @Schema(description = "呼吸率")
    private Integer br;

    @Schema(description = "心率异常")
    private Integer hrException;

    @Schema(description = "呼吸异常")
    private Integer brException;

    @Schema(description = "收缩压")
    private Integer sbp;

    @Schema(description = "收缩压异常")
    private Integer sbpException;

    @Schema(description = "舒张压")
    private Integer dbp;

    @Schema(description = "舒张压异常")
    private Integer dbpException;

    @Schema(description = "监测时间")
    private String ts;

    @Schema(description = "体动")
    private Integer movingCount;

    @Schema(description = "运动异常")
    private Integer moveException;

    @Schema(description = "显示结果可能存在异常")
    private Integer resultException;

    @Schema(description = "舒张压区间值")
    private BigDecimal[] sbpFigure;

    @Schema(description = "舒张压区间值")
    private BigDecimal[] dbpFigure;

    /**
     * 节律图最新点
     */
    @Schema(description = "节律图点（心率趋势图）")
    private BigDecimal[] buffer;

    /**
     * 波形最新点结果
     */
    @Schema(description = "呼吸波形")
    private BigDecimal[] brFigure;

    @Schema(description = "BCG波形（心冲击信号）")
    private BigDecimal[] bcgFigure;

    @Schema(description = "ECG波形（心电信号）")
    private BigDecimal[] ecgFigure;

    /**
     * 统计结果
     * 精神疲劳活跃度
     */
    @Schema(description = "心率值趋势")
    private BigDecimal[] bmpBuffer;

    @Schema(description = "疲劳值波形")
    private BigDecimal[] fatigueBuffer;

}
