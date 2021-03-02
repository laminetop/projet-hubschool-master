FROM openjdk:8-jre-alpine
MAINTAINER alygueye@gmail.com
ADD maven/@@project.build.finalName@@.@@project.packaging@@ /opt/spring-cloud/lib/
ENV ADDITIONAL_EUREKA_SERVER_LIST=''
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/spring-cloud/lib/@@project.build.finalName@@.@@project.packaging@@"]
EXPOSE 8761
