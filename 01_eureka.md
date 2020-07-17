# eureka

##1  eureka介绍

Eureka用于管理各种服务功能包括服务的注册、发现、熔断、负载、降级等 

Eureka由两个组件组成：Eureka服务器和Eureka客户端。Eureka服务器用作服务注册服务器。Eureka客户端是一个java客户端，用来简化与服务器的交互、作为轮询负载均衡器，并提供服务的故障切换支持。Netflix在其生产环境中使用的是另外的客户端，它提供基于流量、资源利用率以及出错状态的加权负载均衡。 

![](assets/1594805173277.png)

上图描述了Eureka的基本架构，由3个角色组成：

1、Eureka Server

- 提供服务注册和发现

2、Service Provider

- 服务提供方
- 将自身服务注册到Eureka，从而使服务消费方能够找到

3、Service Consumer

- 服务消费方
- 从Eureka获取注册服务列表，从而能够消费服务



##2 运行演示

Eureka 服务端代码见:   /_01_eureka_server

注册中心访问: http://localhost:8761/

![](assets/1594805437478.png)



3 配置文件

```yaml
# 端口号
server:
  port: 8761
# 服务注册相关配置
eureka:
  # 服务实例主机名
  instance:
    hostname: localhost
  # 服务提供者配置
  client:
    # 不进行注册（当服务注册中心是单点而非高可用时的配置方式）
    registerWithEureka: false
    # 不获取注册信息（当服务注册中心是单点而非高可用时的配置方式）
    fetchRegistry: false
    # 服务注册中心地址
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```



eureka的一些常用配置

```yaml
#服务注册中心端口号
server.port=1110
#服务注册中心实例的主机名
eureka.instance.hostname=localhost
#是否向服务注册中心注册自己
eureka.client.register-with-eureka=false
#是否检索服务
eureka.client.fetch-registry=false
#服务注册中心的配置内容，指定服务注册中心的位置
eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
# 定时刷新本地缓存时间：5秒  表示eureka client间隔多久去拉取服务注册信息
eureka.client.registryFetchIntervalSeconds:5
# 测试时关闭自我保护机制，保证不可用服务及时踢出
eureka.server.enable-self-preservation=false

# 心跳检测检测与续约时间

# 测试时将值设置设置小些，保证服务关闭后注册中心能及时踢出服务
# 每间隔1s，向服务端发送一次心跳，证明自己依然”存活“
eureka.instance.lease-renewal-interval-in-seconds= 1
# 告诉服务端，如果我2s之内没有给你发心跳，就代表我“死”了，将我踢出掉
eureka.instance.lease-expiration-duration-in-seconds= 2
```

