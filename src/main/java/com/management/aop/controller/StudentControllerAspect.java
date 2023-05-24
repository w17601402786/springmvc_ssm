package com.management.aop.controller;

import com.management.pojo.Users;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class StudentControllerAspect {


    @Autowired
    HttpServletRequest request;

    /**
     * 检测是否为老师
     */
    @Before("execution(* com.management.controller.StudentController.*(..))")
    public void checkAdmin() {

        Users users = (Users) request.getSession().getAttribute("user");


        if (users == null) {
            throw new RuntimeException("未登录");
        }


        if (!users.getUserType().equals("student")) {
            throw new RuntimeException("权限不足");
        }

    }


}
