package com.tqsm.life.interfaces;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.time.LocalDateTime;

/**
 * 设备号：3f0032000651383131333635,29002c000851383131333635,17003f000c504b4b48353420
 *
 * @author qtx
 * @since 2023/8/21
 */
@HttpExchange(value = "/results")
public interface LifeClient {

    /**
     * 有人/无人
     *
     * @param userId 设备号
     */
    @GetExchange("/state")
    String isPerson(@RequestParam String userId);

    /**
     * 血压计算结果
     *
     * @param userId 设备号
     */
    @GetExchange("/bp")
    String bloodPressure(@RequestParam String userId);

    /**
     * 血压波形结果
     *
     * @param userId 设备号
     */
    @GetExchange("/bp/figure")
    String bloodPressureFigure(@RequestParam String userId);

    /**
     * 血压统计结果
     *
     * @param userId 设备号
     */
    @GetExchange("/bp/summary")
    String bloodPressureSummary(@RequestParam String userId);

    /**
     * 血压波形最新点结果
     *
     * @param userId 设备号
     */
    @GetExchange("/bp/pub/figure")
    String bloodPressurePubFigure(@RequestParam String userId);

    /**
     * 疲劳计算结果
     *
     * @param userId 设备号
     */
    @GetExchange("/fatigue/pub")
    String fatiguePub(@RequestParam String userId);

    /**
     * 疲劳节律图最新点
     *
     * @param userId 设备号
     */
    @GetExchange("/fatigue/pub/rhythm")
    String fatiguePubRhythm(@RequestParam String userId);

    /**
     * 疲劳统计结果
     *
     * @param userId 设备号
     */
    @GetExchange("/fatigue/pub/summary")
    String fatiguePubSummary(@RequestParam String userId);

    /**
     * 缓存结果
     *
     * @param userId 设备号
     */
    @GetExchange("/cache")
    String cache(@RequestParam String userId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime bTime, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime eTime);
}
