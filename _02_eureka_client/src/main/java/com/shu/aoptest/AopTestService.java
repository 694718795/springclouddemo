package com.shu.aoptest;


import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class AopTestService {


    public void a(){
        System.out.println("a方法中: 执行b()之前");
        getHelloServiceImpl().b();
        System.out.println("a方法中: 执行b()之后");

    }

    public void b(){
        System.out.println("执行b方法");

    }

    /**
     * 强制获取代理对象，必须开启exposeProxy配置，否则获取不到当前代理对象
     * @return
     */
    private AopTestService getHelloServiceImpl() {
        return AopContext.currentProxy() != null ? (AopTestService) AopContext.currentProxy() : this;
    }


}
