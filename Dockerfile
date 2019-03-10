FROM java:8

VOLUME /tmp

EXPOSE 8080

ADD /build/libs/pismotransaction-0.0.1-SNAPSHOT.jar pismotransaction-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","pismotransaction-0.0.1-SNAPSHOT.jar"]
