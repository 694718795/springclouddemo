package com.shu.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAndAdvice {

    @Before("execution(* com.shu.aoptest.AopTestService.a(..))")
    public void adviceA(JoinPoint jp){
        //控制台只打印了 "执行adviceA"
        System.out.println("aop中 执行adviceA");
    }

    @Before("execution(* com.shu.aoptest.AopTestService.b(..))")
    public void adviceB(JoinPoint jp){
        System.out.println("aop中  执行adviceB");

    }
}
