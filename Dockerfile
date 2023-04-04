FROM eclipse-temurin:17
COPY ./build/libs/kiwa-api.jar /

CMD ["java","-jar","kiwa-api.jar"]
