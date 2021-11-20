# Spring boot

Because of its fast, low configuration, in-built server, and monitoring features, it helps to build a stand-alone java application from scratch which is very robust and maintainable.



Spring Boot automatically configures your application based on the dependencies you have added to the project by using annotation.



Spring boot starter is a maven template that contains a collection of all the relevant transitive dependencies that are needed to start a particular functionality.



Spring Boot dependency management is used to manage dependencies and configuration automatically without you specifying the version for any of that dependencies.



we can replace the Embedded Tomcat server with any server by using the Starter dependency in the **pom.xml** file. Like can use spring-boot-starter-jetty as a dependency for using a jetty server in the project.



@RestController is a combination of @Controller and @ResponseBody, used for creating a restful controller. It converts the response to JSON or XML. It ensures that data returned by each method will be written straight into the response body instead of returning a template.

@Controller Map of the model object to view or template and make it human readable but @RestController simply returns the object and object data is directly written in HTTP response as JSON or XML.



On a high-level spring boot application follow the MVC pattern.&#x20;

Client - Controller - Service - Repository



Spring has the provision of Profiles to keep the configuration separate for the environments.



Actuators include auditing, health, CPU usage, HTTP hits, and metric gathering, and many more.



POM - Project Object Model
