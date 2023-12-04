FROM openjdk:17

MAINTAINER wyler "1102214883@qq.com"

ADD target/life-0.0.1-SNAPSHOT.jar java.jar

#设置镜像对外暴露端口
EXPOSE 1618

# 执行启动命令
ENTRYPOINT ["java","-jar","/java.jar",">/java.log &"]


