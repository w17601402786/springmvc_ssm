package com.management.controller;

import com.management.pojo.Config;
import com.management.pojo.Users;
import com.management.tools.ResultCommon;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/config")
public class ConfigController {

    //TODO 这是一个新的类Config,用于管理全网站的配置
    //TODO 请你实现管理员配置当前学期以及开学日期的功能、设计ConfigMapper.xml
    //TODO ConfigMapper.java、ConfigService.java、ConfigServiceImpl.java
    //TODO AdminController.java(添加配置的改查功能，全局必须要有配置，所以不能删增)
    @Operation(summary = "添加用户")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @RequestMapping(value = "/config",produces = "application/json",method = RequestMethod.GET)
    public ResultCommon<Config> addUser() {

        Config data = new Config();
        data.setYear(2023);
        data.setTerm(1);
        data.setFromDay(LocalDate.of(2023,2,11));


        return new ResultCommon<>(200, "获取成功",data);
    }
}
