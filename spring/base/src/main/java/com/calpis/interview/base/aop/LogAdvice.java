package com.calpis.interview.base.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/28 16:38
 */
@Aspect
@Component
public class LogAdvice {

    @Pointcut("execution(* com.calpis.interview.base.service.*.*(..))")
    public void requestLog() {

    }

    @Around("requestLog()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before...");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("after...");
        return result;
    }
}
