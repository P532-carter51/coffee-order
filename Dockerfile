FROM eclipse-temurin:17
WORKDIR /home

COPY ./target/coffee-order-0.0.1-SNAPSHOT.jar coffee-order-0.0.1-SNAPSHOT.jar

# Copy the db text file to home directory
COPY db.txt /home/

ENTRYPOINT ["java", "-jar", "coffee-order-0.0.1-SNAPSHOT.jar"]