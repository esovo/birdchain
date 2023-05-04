FROM openjdk:17

# 환경 변수 설정
ENV MYSQL_PORT=your_mysql_port \
    MYSQL_USERNAME=your_mysql_username \
    MYSQL_PASSWORD=your_mysql_password \
    AWS_CREDENTIALS_ACCESSKEY=your_aws_access_key \
    AWS_CREDENTIALS_SECRETKEY=your_aws_secret_key \
    CORS_ORIGINS=${cors_origins}

WORKDIR /app
COPY build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

