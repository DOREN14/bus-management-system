FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY busmanagement/ ./busmanagement/

RUN find . -name "*.java" > sources.txt && \
    javac -d out @sources.txt && \
    rm sources.txt && \
    echo "Main-Class: busmanagement.main.BusSystem" > manifest.txt && \
    jar cfm BusManagementSystem.jar manifest.txt -C out . && \
    rm manifest.txt

CMD ["java", "-jar", "BusManagementSystem.jar"]
