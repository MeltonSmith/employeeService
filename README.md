Employee pet service
--------------------------------------
Basic service for inventory project.
Other services (job and inventory) will depend on this one;


Stack planned: Java 11, SpringBoot, Eureka-client, MongoDB, Spring Reactive API, Spring Actuator; 
JMX? Hystrix? Security?

Dev/Testing: Nested mongoDB, Mockito, Junit launching via IDEA so far;
Prod: Docker, MongoDB


Current TODO:
--------------------------------------
    - Figure out how to insert data into nestedMongoDB on startup;
    - Autofill doesn't work so far.
    - Also post request on "/employee" takes only a latin named persons
    - Separate profiles in application.yml

Bugs
--------------------------------------
    - None

Road map
--------------------------------------
Should be able:

- crud Employee (so far)

All end points of Actuator are open;
Nested mongo DB is run on port 12345.
