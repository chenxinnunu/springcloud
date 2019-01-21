#基于哪个镜像
FROM java:8
#将本地文件夹挂载到当前容器
VOLUME /tmp
#复制文件到容器
ADD ./target/hystrix-turbine-1.0.0.jar /app.jar
#执行命令
RUN bash -c 'touch /app.jar'
#声明要暴露的端口
EXPOSE 7000
#配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","/app.jar"]