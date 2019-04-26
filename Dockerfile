FROM openjdk:8u151-jre-stretch

ENV PROJECT_NAME chattheme 
ENV VERSION 1.0-SNAPSHOT
ENV SECRET QUStej67ubRe

RUN mkdir /usr/src/app

WORKDIR /usr/src/app

COPY target/universal/${PROJECT_NAME}-${VERSION}.zip ./

RUN unzip ${PROJECT_NAME}-${VERSION}.zip

WORKDIR /usr/src/app/${PROJECT_NAME}-${VERSION}

RUN chmod a+x bin/${PROJECT_NAME}

CMD rm -rf RUNNING_PID && bin/${PROJECT_NAME} -Dapplication.secret=${SECRET}

EXPOSE 9000 9000
