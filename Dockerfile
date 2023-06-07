# define base docker image

FROM openjdk:17
LABEL maintainer="sanketh"
ADD target/JavaMS-0.0.1-SNAPSHOT.jar JavaMS-Docker.jar
ENTRYPOINT [ "java", "-jar", "JavaMS-Docker.jar" ]
