# MTT Technical Test

### About

This project was created as part of MTT technical evaluation. This solution was created by Douglas Oliveira.

The goal is to allow create a REST endpoint where applications can consume information about flights availability, searching by Airport Origin, Airport Destination, Departure Date, Return Date and number of passengers. This webservice should consume an airline webservice to obtain such information.

### Components Used
- Java 7
- Spring Boot 1.3.5
- Apache Camel 2.17.1 (camel-spring-boot and camel-restlet)
- Restlet Spring Ext 2.3.1
- JodaTime 2.9.4
- Gson 3.3.1
- Groovy 2.3.7

The build is made with Gradle using Groovy plugin. Although sources files are in Java, this structure allows future evolution and use of Groovy files, even mixed with Java.

### How to test
- Build project
```
gradle clean build
```

- Run project
```
gradle bootRun
```

The default start port is 8080 (this can be changed in the application.properties file)

- After starting the application, consume the created endpoint with a REST Client, or simply paste the URL in a browser, since it uses a GET method.
```
GET http://localhost:8096/rest/flights/availability/DUB/DEL/20151007/20151020/2
```


### Considerations

- I chose to use Java 7 because that is the current environment I work on and I have my workspace already setup for that. That saved me time and allowed me to focus more on the task given.

- I am new to Groovy and Camel (I have used it in the past for specific things like triggering EDI file integration for banks), but decided to ensure I made my project able to use these technologies. Putting it all together and making it work took me some time, that is why I tried stick with a simple solution, but it worked well!

- My understanding is that the problem received is a lot more related to converting a MediaType from XML to JSON, rather than requiring more complex implementations where we would need to call multiple webservices, aggregate their values, apply business rules, etc.

Therefore, I choose to keep it simple and work mostly with Camel (even to provide the REST Endpoint that returns JSON) to make this integration, rather than using the full Spring MVC with Controller and Service Classes as we usually work with.  Besides this lack of business complexity, I noticed from the interviews and job descriptions how Camel is used a lot for MTT integrations and decided to give a focus on it.

- Once again, since there are not a lot more than converting the response of the airline webservice, the one and main Design Pattern here is Adapters. There was no need to have a lot of code to actually consume the airline webservice. The is also not a lot of code to provide the REST endpoint converted to Json, I let Camel do the trick. Most of the code is to actually convert the Data and guarantee the integrity of the information.

- I found it was extremely important to have a fixed output Json POJO and adapters that treat the data received. We do not want our REST endpoint to change its contract interface if the airline webservice is changed. That is why I stick with the adapters, and did not use Camel xmljson conversion or anything more automatic. I also wanted to have control over every little piece of conversion.

- I tried to make the code as clean as possible, made sure I have very small testable unit pieces (instead of single big classes of code), each one with their own responsibilities.  I tried to make sure the adapters work well with any input received, and in order to have better availability of the service, cases of errors in parsing any of the small pieces will not affect the rest of the code. For example, if the airline doesn't send a tax price, or sends it in an invalid format, all the rest of the information will still be loaded.

Some of the things I certainly wanted to do if I had more time are listed below. Given the short time available, I focused more on solving the problem, having a clear, working and tested code, but would for sure explore the following items if I had more time:

- Explorer further the Groovy language. I did the minimum setup to allow for it to work, but since I had very little time I chose to stick with Java files (which I have more experience with) to complete the task in time.

- Add further validation to the REST API inputs. For example validate the Airports acronyms against an in-memory Set, and the other inputs that are received in the URL. 

- Execute and evidence stress tests with Jmeter on the API

- Make a Swagger API documentation for the JSON interface of the REST API

- Create authentication layer to allow consumption of endpoint only by applications that are really allowed (using, for example, Spring Security/OAuth)

- Written more Unit and integration tests

- Work with slf4j logger with strategic keys and values to log data and allow to understand the flow of the requests received ( with success and errors), so that they can later be troubleshot and provide more details on info, error and warning events, and generate hashes for eventual errors. I would also like to have had time to treat such errors nicely exposing only relevant HTTP status (400, 401, 403, 404, 500, etc) etc and provide nice messages, but I had time to focus more on the technologies used and converting the data.
