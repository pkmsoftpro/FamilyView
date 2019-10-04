FROM openjdk:8

ADD target/FamilyView-1.0.0.jar FamilyView-1.0.0.jar
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "FamilyView-1.0.0.jar"]