### 使用zipkin实现HTTP方式链路跟踪
- 在控制台输入获取zipkin.jar的地址
   
   因为在springboot2.0以后，官方不再建议自己搭建zipkin的服务端，而是提供现成的jar包，直接运行即可.参考网址:http://www.bubuko.com/infodetail-2596757.html
```
curl -sSL https://zipkin.io/quickstart.sh | bash -s
```
![输入图片说明](https://gitee.com/uploads/images/2018/0615/115326_1fc7122e_1305332.png "屏幕截图.png")
- 在控制台输入命令，启动zipkin的服务端。在下面截图中，我把zipkin.jar包移动到了我的E:\keluosi\zipkin下面
```
java -jar zipkin.jar
```
![输入图片说明](https://gitee.com/uploads/images/2018/0615/115525_993ec2f7_1305332.png "屏幕截图.png")
- 在页面输入zipkin服务端的地址查看zipkin的页面，控制台会打印zipkin的端口号，这里默认为9411

```
http://localhost:9411/zipkin
```
![输入图片说明](https://gitee.com/uploads/images/2018/0615/115941_4168bd44_1305332.png "屏幕截图.png")

- 在微服务的生产者和消费者配置zipkin
1. 在pom.xml文件导入依赖

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```
2. 在application.yml文件中配置zipkin的服务端地址

```
spring:
  zipkin:
    base-url: http://localhost:9411/
```
- 打开zipkin页面就可以看到调用链情况了
![输入图片说明](https://gitee.com/uploads/images/2018/0615/130513_323b58d1_1305332.png "屏幕截图.png")

### 使用zipkin实现消息总线RabbitMQ方式链路跟踪
因为之前说的 Zipkin 不再推荐我们来自定义 Server 端了，所以在最新版本的 Spring Cloud 依赖管理里已经找不到 zipkin-server 了。
可以通过环境变量让 Zipkin 从 RabbitMQ 中读取信息，就像这样：
RABBIT_ADDRESSES=localhost java -jar zipkin.jar
在微服务应用中加入spring-cloud-stream-binder-rabbit就好了，别的不用改
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-stream-binder-rabbit</artifactId>
</dependency>
```
不过为了说明是通过 RabbitMQ 传输的信息，
将spring.zipkin.base-url均改为http://localhost:9412/，即指向一个错误的地址。
启动微服务，并启动Zipkin
RABBIT_ADDRESSES=localhost java -jar zipkin.jar
访问微服务，并刷新Zipkin UI,得到信息