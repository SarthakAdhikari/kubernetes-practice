FROM amazoncorretto:17-alpine

WORKDIR /usr/app

COPY target/tweet-service-0.0.1-SNAPSHOT.jar tweets-service.jar

EXPOSE 8001

CMD ["java", "-jar", "tweets-service.jar", "--spring.profiles.active=prod"]
