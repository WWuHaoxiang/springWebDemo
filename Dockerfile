# 使用 Java 17 镜像作为基础
FROM amazoncorretto:17

## 添加参数
#ARG JAR_FILE
#
## 添加 Spring Boot 包
#ADD target/${JAR_FILE} e4_student-0.0.1-SNAPSHOT.jar
COPY target/e4_student-0.0.1-SNAPSHOT.jar /e4_student-0.0.1-SNAPSHOT.jar

LABEL authors="WuHaoxiang"
# 执行启动命令
#ENTRYPOINT ["java", "-jar", "/e4_student-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/e4_student-0.0.1-SNAPSHOT.jar"]
