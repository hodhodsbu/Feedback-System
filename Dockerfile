FROM maven:3.6.0 as build_env

COPY . /opt/hodhod_project
WORKDIR /opt/hodhod_project

RUN mvn clean package -DskipTest

FROM mcr.microsoft.com/java/jdk:11-zulu-ubuntu

RUN chmod +x /opt/hodhod_project/bin/buid.sh

ENTRYPOINT ["/opt/project/bin/build.sh"]
