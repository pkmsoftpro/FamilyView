# FamilyView
Hospital Management


#Docker Components
C:\Users\Miracle\eclipse-workspace

https://github.com/bamossza/spring-boot-jpa-oracle-project/blob/master/src/main/resources/application.properties

download the file: https://stackoverflow.com/questions/32000104/missing-artifact-com-oracleojdbc7-in-eclipse

mvn install:install-file -Dfile=C:\Users\Miracle\Downloads\ojdbc7-12.1.0.2.jar -DgroupId=com.oracle  -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar -DgeneratePom=true


npm install
ng serve





MYSQL database:
root
Ch@122395


maven.test.skip=true


Docker:
Edureka: https://www.youtube.com/watch?v=iJeL2tOFfvM
Tech Primers: https://www.youtube.com/watch?v=FlSup_eelYE

docker ps -a

docker rm [docker-name]
docker rmi [container-image-id]

$ docker build -t familyview .
docker run -it -p 8081:8081 familyview

 docker run -it -p 8081:8081 familyview
 
 $ docker build -f Dockerfile -t familyview .
 
 docker run -t --name familyview --link docker-mysql:mysql -p 8082:8081 familyview


https://hub.docker.com/r/dicadeveloper/docker-java-mysql-test

https://gitlab.com/Dica-Developer/docker-java-mysql-test/blob/master/Dockerfile


docker image
*********************-----------------------------------------------------------********************************
FROM phusion/baseimage:0.11

MAINTAINER Martin Schaaf

# this is a non-interactive automated build - avoid some warning messages
ENV DEBIAN_FRONTEND noninteractive

RUN rm -f /etc/service/sshd/down

CMD ["/sbin/my_init"]

RUN apt-get update

RUN apt-get upgrade -y

# install necessary tools for a test environment
RUN apt-get install openjdk-8-jdk-headless openjdk-11-jdk-headless xvfb  nodejs gnupg2 ca-certificates libgtk2.0-0 libnotify-dev libgconf-2-4 libnss3 libxss1 libasound2 -y
RUN curl -sL https://deb.nodesource.com/setup_10.x | bash -
RUN apt-get install -y nodejs

RUN apt-key adv -v --fetch-keys https://dl.yarnpkg.com/debian/pubkey.gpg
RUN echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list
RUN apt-get update

RUN apt-get install -y yarn
RUN apt-get install -y git
RUN apt-get install -y ssh

# install mysql
RUN { \
    echo mysql-community-server mysql-community-server/data-dir select ''; \
    echo mysql-community-server mysql-community-server/root-pass password ''; \
    echo mysql-community-server mysql-community-server/re-root-pass password ''; \
    echo mysql-community-server mysql-community-server/remove-test-db select true; \
  } | debconf-set-selections \
  && apt-get install mysql-server -y

RUN service mysql restart ; echo "update user set Host = '127.0.0.1', plugin ='mysql_native_password', authentication_string = '*81F5E21E35407D884A6CD4A731AEBFB6AF209E1B' where User = 'root'" | mysql -u root mysql ; service mysql stop

# clean apt
RUN apt-get -y autoremove
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

RUN mkdir -p /etc/my_init.d
RUN echo "#!/bin/sh" > /etc/my_init.d/mysql.sh
RUN echo "service mysql start" >> /etc/my_init.d/mysql.sh
RUN chmod a+x /etc/my_init.d/mysql.sh


mine:-------------------
FROM openjdk:8

# install mysql
RUN { \
    echo mysql-community-server mysql-community-server/data-dir select ''; \
    echo mysql-community-server mysql-community-server/root-pass password ''; \
    echo mysql-community-server mysql-community-server/re-root-pass password ''; \
    echo mysql-community-server mysql-community-server/remove-test-db select true; \
  } | debconf-set-selections \
  && apt-get update && apt-get install mysql-server -y

RUN service mysql restart ; echo "update user set Host = '127.0.0.1', plugin ='mysql_native_password', authentication_string = '*9C613C2772E61628C8DC95F830849992FFA5A689' where User = 'root'" | mysql -u root mysql ; service mysql stop

Add target/FamilyView-1.0.0.jar FamilyView-1.0.0.jar
Expose 8080

ENTRYPOINT ["java", "-jar", "FamilyView-1.0.0.jar"]


*********************-----------------------------------------------------------********************************


generate mysql password:
https://www.browserling.com/tools/mysql-password



https://medium.com/@itsromiljain/dockerize-rest-spring-boot-application-with-hibernate-having-database-as-mysql-579abcc4edc4
https://github.com/itsromiljain/gradle-springboot/tree/master/src/main/resources


$ docker run -p 3306:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=test" mysql  
$ docker run -t --name familyview --link docker-mysql:mysql -p 8082:8081 familyview



https://www.javainuse.com/devOps/docker/docker-mysql




docker ps -a

docker rm [docker-name]
docker rmi [container-image-id]
