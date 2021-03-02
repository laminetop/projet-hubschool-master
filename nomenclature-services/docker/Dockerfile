FROM openjdk:8-jre-alpine
MAINTAINER alygueye@gmail.com
ADD maven/@@project.build.finalName@@.@@project.packaging@@ /opt/app/lib/
ENV CONFIG_SERVER_ADDRESS='http://localhost:8888'
ENV EUREKA_SERVER_ADDRESS='http://localhost:8761/eureka/'
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/app/lib/@@project.build.finalName@@.@@project.packaging@@"]
EXPOSE 8080
