package com.management.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GradeAspect {

    @Pointcut("execution(* com.management.service.impl.GradeServiceImpl.*(..))")
    public void gradeServicePointcut() {
    }

    @Before("gradeServicePointcut()")
    public void checkGrade() {

        //判断当前调用的方法
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName);


    }



}
