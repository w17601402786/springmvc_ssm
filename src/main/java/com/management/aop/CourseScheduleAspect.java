package com.management.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 课程表插入前的检测
 * 此为排课控制器的切面
 * 用于检测课程表的插入是否合法
 * <ol>
 *     <li>若当前要排课的教室在当前时间时间存在其他课程，则不允许排课</li>
 *     <li>若当前要排课的老师在当前时间存在其他课程，则不允许排课</li>
 *     <li>若当前要排课的班级在当前时间存在其他课程，则不允许排课</li>
 * </ol>
 */
@Component
@Aspect
public class CourseScheduleAspect {

    private final Integer TEACHER_HAVE_CLASS_ERROR = 1;
    private final Integer CLASS_HAVE_CLASS_ERROR = 1<<1;
    private final Integer CLASSROOM_HAVE_CLASS_ERROR = 1<<2;

    @Pointcut("execution(* com.management.service.impl.CourseScheduleServiceImpl.*(..))")
    public void courseScheduleServicePointcut() {
    }

    /**
     * 排课控制
     */
    @Before("courseScheduleServicePointcut()")
    public void checkCourseSchedule(JoinPoint joinPoint) {

        System.out.println("检测课程表");

        //TODO: 排课控制

        String errorMsg = "";

        if (!errorMsg.equals("")) {
            throw new RuntimeException(errorMsg);
        }

    }

    /**
     * 检测插入的各种外键是否存在
     */
    @Before("execution(* com.management.service.impl.CourseScheduleServiceImpl.add*(..))")
    public void checkForeignKey() {

        //TODO: 检测外键
        System.out.println("检测外键");

    }

}
