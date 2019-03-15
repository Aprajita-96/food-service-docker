#//step1.pull jdk image

#//Add:/copy jar file from target to docker file system
# Run the JarFile java

FROM openjdk:11

ADD ./target/foodie-service-0.0.1-SNAPSHOT.jar /usr/src/foodie-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "foodie-service-0.0.1-SNAPSHOT.jar"]