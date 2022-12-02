From openjdk:11
copy target/MovieSchedule-0.0.1-SNAPSHOT.jar MovieSchedule-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","MovieSchedule-0.0.1-SNAPSHOT.jar"]
EXPOSE 8086
