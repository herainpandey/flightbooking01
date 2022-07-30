FROM openjdk:8u191-jre-alpine3.8

WORKDIR /usr/share/udemy

#ADD .jar under target from host

ADD target/selenium-docker.jar       selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs                      libs

ADD testng.xml                       testng.xml

ENTRYPOINT java -cp selenium-docker.jar;selenium-docker-tests.jar;libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST com.testng.TestNG $MODULE