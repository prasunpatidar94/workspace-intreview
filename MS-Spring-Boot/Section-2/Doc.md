# Section-2

URL:-
https://github.com/eazybytes/microservices/tree/3.4.1/section2

## Port Details

- #### Account Port: 8080
- #### Loan Port:8081
- #### Cards: 8081

#### Swagger URI

```http://localhost:8080/swagger-ui/index.html```
```http://localhost:8081/swagger-ui/index.html```

``` C:\Users\Someone\AppData\Roaming\JetBrains\IntelliJIdea2025.1\options\proxy```
--

### Docker mysql run command

``` shell 
    $ docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpass -e MYSQL_DATABASE=sunbank -e MYSQL_USER=user -e MYSQL_PASSWORD=pass123 -p 3306:3306 -d mysql:8.0
 ```

#### docker-compose.yaml

``` json 
    version: '3.8'
    services:
    mysql:
    image: mysql:8.0
    container_name: mysql-container
    ports:
    - "3306:3306"
    environment:
    MYSQL_ROOT_PASSWORD: rootpass
    MYSQL_DATABASE: mydb
    MYSQL_USER: user
    MYSQL_PASSWORD: userpass
    volumes:
    - mysql_data:/var/lib/mysql
    
    volumes:
    mysql_data:
```

#### SQL Database / Tables

```sql
    select *
    from sunbank.loan;
    select *
    from sunbank.customer;
    select *
    from sunbank.accounts;
```

## resizing attaches (approach to divide work in small pieces)

- domain driven design
- event driven design

## Strangler fig pattern

- best to migrate from one big complex legacy application to microservices
- identification -> transformation-> co-existence -> elimination

## Challenge #3 (deployment, scalability, Portability)

- solution id containerization (with docker and kubernetes)
    - there are 3 approached to create docker image:
      ### 1>  manual create docker file using (Dockerfile)
        - mvn clean install -> to generate fat jar of application (
        - ``` xml
            <groupId>com.sun</groupId>
              <artifactId>accounts</artifactId>
              <version>0.0.1-SNAPSHOT</version>
              <packaging>jar</packaging> --- this we needed to add 
              <name>accounts</name>
              <description>Accounts microservices practice</description>
          ```
        - ``` shell 
            mvn spring-boot:run -- > help to run fat jar of application in spring boot 
            java -jar <JAR_NAME>.jar -- > another way to run fat jar file in java 
        ```
        - ```dockerfile 
            #File name :Dockerfile
            #start with base image for platfoem 
            FROM openjdk:17-jdk-slim
            MAINTAINER codeBySUN.com
            COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar
            ENTRYPOINT ["java,","-jar","accounts-0.0.1-SNAPSHOT.jar"]
          ```
        - ```shell
            docker build . -t codebysun/accounts:0.1v --> ceate image command 
            docker image list
            docker container list
            docker inspect image  <IMAGE ID>
            docker run -d -p 8080:8080 codebysun/accounts:0.1v 
        ```
  
      ### 2>  BuildPack ecosystem to carte Docker images
        - [BuildPack URL](https://buildpacks.io/)
            - Needed to add image configuration
                - for gradle :
                ``` json
                     
                         bootBuildImage {
                          imageName = "codebysun/${rootProject.name}:v1" // Docker image name
                          environment = [
                           'BP_JVM_VERSION': '17'                    // Set Java version in the image
                          ]
                           }
                ```
          ``` shell
            gradle bootBuildImage 
          ```
          - for maven
            ``` xml
                <configuration>
                    <image>
                      <name>sun/sunbank:latest</name> <!-- ✅ No docker.io prefix -->
                    </image>
                  </configuration>
            ```
            ``` shell
            mvn spring-boot:build-image 
            ```
        ### google jib image builder
        - gradle configuration
      ```groovy
        plugins {
        id 'java'
        id 'org.springframework.boot' version '3.5.4'
        id 'io.spring.dependency-management' version '1.1.7'
        id 'com.google.cloud.tools.jib' version '3.4.5' /---  jib plugin
        
        }
        
        jib.to.image="codebysun/${rootProject.name}:v1" ---jib image name 

        ```
        - jib builder / fat jar builder command 
        ```shell
            gradle clean 
            gradel build OR gradel build --warning-mode=all
            gradle jib ---> build image and push on image repogitory
            gradle jibDockerBuild ---> to build image local docker
            gradle clean compileJava build jibDockerBuild -x test
        ```
      - jib builder with maven 
        ```xml
            <plugin>
                    <groupId>com.google.cloud.tools</groupId>
                    <artifactId>jib-maven-plugin</artifactId>
                    <version>3.4.6</version>
                    <configuration>
                        <to>
                            <image>codebysun/accounts:latest</image>
                        </to>
                    </configuration>
            </plugin>
        ```
    - jib builder / fat jar builder command with mvn
        ```shell
            mvn clean  compile jib:dockerBuild -DskipTests
            mvn clean compile install jib:dockerBuild -DskipTests
            mvn compile jib:build  -->registory push
        ```
    ## Docker commands:
    - ``` shell
      docker image list 
      docker image list -a
      docker image push docker.io/codebysun/loans:v1
      docker image push docker.io/codebysun/loans:v1
      docker image run docker.io/codebysun/loans:v1
      docker container list 
      docker container list -a
      docker container stop codebysun/loans:v1
      docker container prone codebysun/loans:v1
      docker image rm codebysun/loans:v1
      ```
## 15-Factor Methodology -:
- to Build batter MS Project.
- created by Heroku (with principal 12) 
- Updated by Kevin Hoffman with principal 3 now totals are 15 principal
#### 1. One code base for one application - use git repo (means each application should have its own code repo.)
#### 2. API first- use Sping boot rest API (always focus on API implementation and integration)
#### 3. Dependency management use maven / Gradle (always get a dependency form centralize place Maven and Gradle is best tool to do it )
#### 4. design->build->release->run use jenkins/ git actions (always create production ready application run it and if any correctio come it fix it and flow same process )
#### 5. Configuration Credentials and Code use Sping server config with spring profile (keep app env related config repeated and enable as par the requirements server )
#### 6. Logs use logs aggregator tool (always make logging tool or mechanizing with MS)
#### 7. Disposability use docker or Kubernetes (if npt working the kill it and create new instance)
#### 8. Backing Services use config server and properties setup (make all attached resource things like DB Queues should be as a service so we can do modification easily without chages)
#### 9. Environment Parity to avoid costly shortcut (if the configuration is similar for 2 enviroment and not much diffrence the keep only minimal diffrences and run application )
#### 10. Administrative Process (follow a process like SIT->UAT-PROD with same data and make it same packages )
#### 11. Port Finding uses port for forwarding used intercommunication (do not deploy multiply application in same server batter we have to used separate server fo0r each application )
#### 12. Stateless Processes use Caching concept or DB  (do not used any service as data store instence of it we should use redis chase or DB ,do not make  dependency tight coupling other )
#### 13. Concurrency use horizontal scaling using threading concept (should support concurrency not sequencing)
#### 14. Telemetry uses actuator, admin console, logs, tracings, health states, etc. (always used observability tool to observe the all service on signal place to monitor)
#### 15. Authentication and authorization use spring security (zero trust approach)