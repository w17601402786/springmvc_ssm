package com.management.aop.controller;

import com.management.pojo.Users;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class AdminControllerAspect {


    @Autowired
    HttpServletRequest request;

    /**
     * 检测是否为管理员
     */
    @Before("execution(* com.management.controller.AdminController.*(..))")
    public void checkAdmin(JoinPoint joinPoint) {

        Users users = (Users) request.getSession().getAttribute("user");


        if (users == null) {
            throw new RuntimeException("未登录");
        }


        if (!users.getUserType().equals("admin")) {
            throw new RuntimeException("权限不足");
        }

        // 获取方法的参数列表
        Object[] args = joinPoint.getArgs();

        // 将参数列表转换为字符串并打印出来
        String argsStr = Arrays.toString(args);
        log.info("前端参数:\n{}",argsStr);

    }


}
