
# Singlestone Technical Exercise - Simple Contact Entry System

1. REST APIs to enable a client to perform CRUD operations on the contact collection
2. Using Java/JVM technologies
    1. Spring Boot - Container for the build and deploy
    2. H2 Database - For storing contact entries
    3. Hibernate - To handle object to relational data mapping
    4. Tomcat - Web server to support HTTP communication to REST service calls
    5. Curl - command line tool for testing REST APIs
 
   
#### Installation and Build Instructions
```sh
Requires following installed
1. Java 8
2. Maven
3. Curl


# Run this command from within the singlestonetechreview directory

mvn clean install


# Run unit tests

mvn test


# Run server

mvn spring-boot:run


# This will start up the Spring Boot tomcat server

http://localhost:8081


# Curl Test scripts 

getContactEntries.sh - curl command to call GET /contacts List all contacts

postContactEntry.sh - curl command to call POST /contacts Create a new contact

putContactEntry.sh - curl command to call PUT /contacts/{id} Update a contact

getSpecificContactEntry.sh - curl command to call GET /contacts/{id} Get a specific contact

deleteContactEntry.sh - curl command to call DELETE /contacts/{id} Delete a contact


# JSON files used for loading to server

tests/contactentry.json
tests/contactentry2.json

```
