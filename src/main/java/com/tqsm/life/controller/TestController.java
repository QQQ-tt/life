package com.tqsm.life.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tqsm.life.config.Result;
import com.tqsm.life.interfaces.LifeClient;
import com.tqsm.life.pojo.life.PersonState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
