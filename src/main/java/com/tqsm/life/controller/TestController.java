package com.tqsm.life.controller;

import com.tqsm.life.config.Result;
import com.tqsm.life.interfaces.LifeClient;
import com.tqsm.life.pojo.life.PersonState;
import com.tqsm.life.pojo.life.result.bp.ResultsBp;
import com.tqsm.life.pojo.life.result.bp.figure.ResultBpFigure;
import com.tqsm.life.pojo.life.result.bp.pub.figure.ResultBpPubFigure;
import com.tqsm.life.pojo.life.result.bp.summary.BpSummary;
import com.tqsm.life.pojo.life.result.cache.ResultCache;
import com.tqsm.life.pojo.life.result.fatigue.pub.PubSummary;
import com.tqsm.life.pojo.life.result.fatigue.pub.ResultsFatiguePub;
import com.tqsm.life.pojo.life.result.fatigue.pub.rhythm.ResultsFatiguePubRhythm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author qtx
 * @since 2023/8/28
 */
@Tag(name = "测试controller")
@RestController
@RequestMapping("/test")
public class TestController {

    private final LifeClient lifeClient;

    public TestController(LifeClient lifeClient) {
        this.lifeClient = lifeClient;
    }

    @Operation(summary = "get测试接口testPerson")
    @GetMapping("/testPerson")
    public Result<PersonState> testPerson(){
        return Result.success(lifeClient.isPerson("29002c000851383131333635"));
    }

    @GetMapping("/testResultsBp")
    public Result<ResultsBp> testResultsBp(){
        return Result.success(lifeClient.bloodPressure("29002c000851383131333635"));
    }

    @GetMapping("/testResultsBpFigure")
    public Result<ResultBpFigure> testResultsBpFigure(){
        return Result.success(lifeClient.bloodPressureFigure("29002c000851383131333635"));
    }

    @GetMapping("/testResultsBpSummary")
    public Result<BpSummary> testResultsBpSummary(){
        return Result.success(lifeClient.bloodPressureSummary("29002c000851383131333635"));
    }

    @GetMapping("/testResultsBpPubFigure")
    public Result<ResultBpPubFigure> testResultsBpPubFigure(){
        return Result.success(lifeClient.bloodPressurePubFigure("29002c000851383131333635"));
    }

    @GetMapping("/testResultsFatiguePub")
    public Result<ResultsFatiguePub> testResultsFatiguePub(){
        return Result.success(lifeClient.fatiguePub("29002c000851383131333635"));
    }

    @GetMapping("/testResultsFatiguePubRhythm")
    public Result<ResultsFatiguePubRhythm> testResultsFatiguePubRhythm(){
        return Result.success(lifeClient.fatiguePubRhythm("29002c000851383131333635"));
    }


    @GetMapping("/testResultsFatiguePubSummary")
    public Result<PubSummary> testResultsFatiguePubSummary(){
        return Result.success(lifeClient.fatiguePubSummary("29002c000851383131333635"));
    }

    @GetMapping("/testResultsCache")
    public Result<ResultCache> testResultsCache(){

        LocalDateTime BTime = LocalDateTime.of(2023, 8, 29, 9, 43, 20);
        LocalDateTime ETime = LocalDateTime.of(2023, 8, 29, 18, 43, 20);
        return Result.success(lifeClient.cache("29002c000851383131333635",BTime,ETime));
    }
}
