# 龙RPC框架

> RPC （Remote Produce Call）既远程调用，允许程序在不同计算机、服务器节点之间像本地调用一样进行通信和交互，
>
> 服务客户端   注册中心   序列化器 负载均衡 容错机制

## 框架设计

![]([image\1.png](https://github.com/LCqaqq/L-RPC/blob/main/image/1.png))
## 主要模块
### 服务客户端

- 基于Vert.X的服务器，实现消费者和提供者的高性能网络通信
- 实现基于HTTP协议的服务器功能实现
- 实现基于自定义TCP协议的服务器功能实现

### 注册中心 

- 基于etcd云原生中间件实现高可用的分布式注册中心
- 利用定时任务和etcd key的TTL实现服务的心跳检测，自动续期机制，下线自动清除注册服务功能
- 通过etcd watch 监听节点过期和自动更新缓存

![]([image\2.png](https://github.com/LCqaqq/L-RPC/blob/main/image/2.png))



### 序列化器

- 实现基于java原生的JDK序列化器
- 实现基于Json的序列化器
- 实现基于Kryo的序列化器
- 实现基于Hessin的序列化器
- 采用工厂设计模式+单例模式+SPI机制 实现通过配置文件扩展和指定序列化器

### 负载均衡

- 实现一致性hash 负载均衡策略
- 轮询 负载均衡策略
- 随机 负载均衡策略
- 采用工厂设计模式+单例模式+SPI机制 实现通过配置文件扩展和指定负载均衡策略

### 容错机制

- retry  重试
- failfast 快速失败
- failover 忽略
