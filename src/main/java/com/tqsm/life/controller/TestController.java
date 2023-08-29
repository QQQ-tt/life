package com.tqsm.life.controller;

import com.alibaba.fastjson.JSONObject;
import com.tqsm.life.config.Result;
import com.tqsm.life.interfaces.LifeClient;
import com.tqsm.life.pojo.life.PersonState;
import com.tqsm.life.pojo.life.result.bp.ResultsBp;
import com.tqsm.life.pojo.life.result.bp.figure.ResultBpFigure;
import com.tqsm.life.pojo.life.result.cache.ResultCache;
import com.tqsm.life.pojo.life.result.fatigue.pub.PubSummary;
import com.tqsm.life.pojo.life.result.fatigue.pub.ResultsFatiguePub;
import com.tqsm.life.pojo.life.result.bp.pub.figure.ResultBpPubFigure;
import com.tqsm.life.pojo.life.result.fatigue.pub.rhythm.ResultsFatiguePubRhythm;
import com.tqsm.life.pojo.life.result.bp.summary.BpSummary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author qtx
 * @since 2023/8/28
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final LifeClient lifeClient;

    public TestController(LifeClient lifeClient) {
        this.lifeClient = lifeClient;
    }

    @GetMapping("/testPerson")
    public Result<PersonState> testPerson(){
        return Result.success(JSONObject.parseObject(lifeClient.isPerson("29002c000851383131333635"), PersonState.class));
    }

    @GetMapping("/testResultsBp")
    public Result<ResultsBp> testResultsBp(){
        return Result.success(JSONObject.parseObject(lifeClient.bloodPressure("29002c000851383131333635"), ResultsBp.class));
    }

    @GetMapping("/testResultsBpFigure")
    public Result<ResultBpFigure> testResultsBpFigure(){
        return Result.success(JSONObject.parseObject(lifeClient.bloodPressureFigure("29002c000851383131333635"), ResultBpFigure.class));
    }

    @GetMapping("/testResultsBpSummary")
    public Result<BpSummary> testResultsBpSummary(){
        return Result.success(JSONObject.parseObject(lifeClient.bloodPressureSummary("29002c000851383131333635"), BpSummary.class));
    }

    @GetMapping("/testResultsBpPubFigure")
    public Result<ResultBpPubFigure> testResultsBpPubFigure(){
        return Result.success(JSONObject.parseObject(lifeClient.bloodPressurePubFigure("29002c000851383131333635"), ResultBpPubFigure.class));
    }

    @GetMapping("/testResultsFatiguePub")
    public Result<ResultsFatiguePub> testResultsFatiguePub(){
        return Result.success(JSONObject.parseObject(lifeClient.fatiguePub("29002c000851383131333635"), ResultsFatiguePub.class));
    }

    @GetMapping("/testResultsFatiguePubRhythm")
    public Result<ResultsFatiguePubRhythm> testResultsFatiguePubRhythm(){
        return Result.success(JSONObject.parseObject(lifeClient.fatiguePubRhythm("29002c000851383131333635"), ResultsFatiguePubRhythm.class));
    }


    @GetMapping("/testResultsFatiguePubSummary")
    public Result<PubSummary> testResultsFatiguePubSummary(){
        return Result.success(JSONObject.parseObject(lifeClient.fatiguePubSummary("29002c000851383131333635"), PubSummary.class));
    }

    @GetMapping("/testResultsCache")
    public Result<ResultCache> testResultsCache(){

        String dateTimeStr1 = "2023-08-17 09:45:27";
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime BTime = LocalDateTime.parse(dateTimeStr1, df1);

        String dateTimeStr2 = "2023-08-18 09:46:27";
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ETime = LocalDateTime.parse(dateTimeStr2, df2);

        return Result.success(JSONObject.parseObject(lifeClient.cache("29002c000851383131333635",BTime,ETime),
                ResultCache.class));
    }
}
