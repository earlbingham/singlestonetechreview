
# Singlestone Technical Exercise - Simple Contact Entry System

1. REST APIs to enable a client to perform CRUD operations on the contact collection
2. Using Java/JVM technologies
    1. Spring Boot - Container for the build and deploy
    2. H2 Database - For storing contact entries
    3. Hibernate - To handle object to relational data mapping
    4. Tomcat - Web server to support HTTP communication to REST service calls
    
#### Installation and Build Instructions
```sh
Requires following installed
1. Java 8
2. Maven

# Run this command from within the singlestonetechreview directory
mvn clean install

# Run unit tests

mvn test

# This will start up the Spring Boot tomcat server
# 
http://localhost:8080

```

