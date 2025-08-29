---

```markdown
# Section 2: Microservices Setup

🔗 **Repository**:  
[GitHub – Section 2](https://github.com/eazybytes/microservices/tree/3.4.1/section2)

## 🛠️ Port Configuration

- **Account Service Port**: `8080`
- **Loan Service Port**: `8081`
- **Cards Service Port**: `8081`

### 🧭 Swagger URLs

```text
http://localhost:8080/swagger-ui/index.html
http://localhost:8081/swagger-ui/index.html
```

📍 IntelliJ Proxy Settings:

```text
C:\Users\Someone\AppData\Roaming\JetBrains\IntelliJIdea2025.1\options\proxy
```

---

## 🐬 Docker MySQL Container Setup

```bash
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpass -e MYSQL_DATABASE=sunbank -e MYSQL_USER=user -e MYSQL_PASSWORD=pass123 -p 3306:3306 -d mysql:8.0
```

### 📦 docker-compose.yaml

```yaml
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

---

## 🗃️ SQL Queries

```sql
SELECT *
FROM sunbank.loan;
SELECT *
FROM sunbank.customer;
SELECT *
FROM sunbank.accounts;
```

---

## 🧩 Architecture Principles

### 📐 Work Segmentation

- Domain-Driven Design
- Event-Driven Design

### 🌿 Strangler Fig Pattern

- Suitable for migrating monolithic legacy applications to microservices  
  Steps: `Identification → Transformation → Co-existence → Elimination`

---

## 🚀 Deployment Challenges & Solutions

### 🐳 Containerization with Docker & Kubernetes

#### 📌 Dockerfile Example

```dockerfile
FROM openjdk:17-jdk-slim
MAINTAINER codeBySUN.com
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]
```

#### 🧪 Docker Commands

```bash
docker build . -t codebysun/accounts:0.1v
docker image list
docker container list
docker inspect <IMAGE_ID>
docker run -d -p 8080:8080 codebysun/accounts:0.1v
```

### 🔧 Spring Boot Fat Jar Commands

```bash
mvn clean install
mvn spring-boot:run
java -jar <JAR_NAME>.jar
```

---

## 🏗️ Docker Image Builders

### 🛠️ Buildpack Configuration ([Buildpacks.io](https://buildpacks.io))

#### Gradle

```groovy
bootBuildImage {
    imageName = "codebysun/${rootProject.name}:v1"
    environment = ['BP_JVM_VERSION': '17']
}
```

```bash
gradle bootBuildImage
```

#### Maven

```xml

<configuration>
    <image>
        <name>sun/sunbank:latest</name>
    </image>
</configuration>
```

```bash
mvn spring-boot:build-image
```

---

### ☁️ Jib Plugin by Google

#### Gradle

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.5.4'
    id 'io.spring.dependency-management' version '1.1.7'
    id 'com.google.cloud.tools.jib' version '3.4.5'
}

jib.to.image = "codebysun/${rootProject.name}:v1"
```

```bash
gradle clean
gradle build --warning-mode=all
gradle jib
gradle jibDockerBuild
```

#### Maven

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

```bash
mvn clean compile jib:dockerBuild -DskipTests
mvn compile jib:build
```

---

## 🧰 Common Docker Commands

```bash
docker image list
docker image list -a
docker image push docker.io/codebysun/loans:v1
docker run docker.io/codebysun/loans:v1
docker container list
docker container stop <container_id>
docker image rm codebysun/loans:v1
```

---

## 🔒 15-Factor Methodology

Based on Heroku's principles (expanded to 15 by Kevin Hoffman):

1. One Codebase → One Repo
2. API First → Spring Boot REST APIs
3. Dependency Management → Maven/Gradle
4. Build → Release → Run (CI/CD: Jenkins/GitHub Actions)
5. Config Separation → Spring Profiles & Config Server
6. Centralized Logging → Log Aggregation Tools
7. Disposability → Docker/Kubernetes
8. Backing Services → Configurable External Services
9. Environment Parity Avoids its Drift Across Environments
10. Admin Processes → SIT → UAT → PROD Flow
11. Port Binding → Dynamic Port Allocation
12. Statelessness → Uses Redis/DB; Avoid Tight Coupling
13. Concurrency → Horizontal Scaling with Threads
14. Telemetry → Actuator, Health, Tracing
15. AuthN/AuthZ → Spring Security (Zero Trust)

---

## 🛠️ Dynamic Configuration Strategies

To make your Spring Boot app adaptable across environments:

1. Spring Boot Properties & Profiles
2. Externalized Configuration
3. Spring Cloud Config Server

### 🧾 Spring Boot Configuration Priority Order (higher to lower)

| No | Configuration Source                              |
|----|---------------------------------------------------|
| 1  | Command Line Arguments                            |
| 2  | `ServletConfig` init Parameters                   |
| 3  | `ServletContext` init Parameters                  |
| 4  | JNDI attributes from `java:comp/env`              |
| 5  | Java System Properties (`System.getProperties()`) |
| 6  | OS Environment Variables                          |
| 7  | `application.properties` file                     |

### we will cover merger 3 used approached

### 📊 Configuration Approaches in Spring Boot

| No | Approach                   | Example                                                                                                      | Benefits                                                                                              | Drawbacks                                                                                              | Use Case                                                                                                |
|----|----------------------------|--------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| 1  | `@Value` Annotation        | `@Value("${server.port}")`<br>Injects single property directly into a field                                  | ✅ Simple and quick for individual values<br>✅ Easy for primitive types                                | ❌ Hard to manage multiple related properties<br>❌ No support for complex object binding                | 🔹 Ideal for injecting isolated primitive values like ports, flags, or single strings                   |
| 2  | `Environment` Interface    | `env.getProperty("spring.datasource.url")`<br>Use inside constructor or method to fetch property dynamically | ✅ Runtime flexibility<br>✅ Can set default values via code<br>✅ Doesn't require annotations           | ❌ Not type-safe<br>❌ Needs manual conversion and error handling<br>❌ Verbose for grouped configs       | 🔹 Suitable for dynamic access, utility components, or custom config loaders with conditional logic     |
| 3  | `@ConfigurationProperties` | `@ConfigurationProperties(prefix = "app")`<br>Maps `app.*` properties into a POJO                            | ✅ Type-safe and object-mapped<br>✅ Clean separation of config logic<br>✅ Excellent for grouped values | ❌ Requires boilerplate (getters/setters)<br>❌ Needs proper component scanning or explicit registration | 🔹 Best for structured config objects (e.g., credentials, service URLs, thresholds) used across the app |

### 🔍 Quick Comparison

| Feature                  | `@Value`           | `Environment`           | `@ConfigurationProperties` |
|--------------------------|--------------------|-------------------------|----------------------------|
| ✅ Type-safety            | ❌ No               | ❌ No                    | ✅ Yes                      |
| ✅ Complex object mapping | ❌ No               | ❌ No                    | ✅ Yes                      |
| ✅ Ease of testing        | ❌ Hardcoded values | ⚠️ Requires mocking     | ✅ Clean POJOs              |
| ✅ Spring Boot friendly   | ✅ Simple usage     | ⚠️ Utility-based access | ✅ Highly recommended       |

---

### 🧪 Example `application.properties`

```properties
# application.properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
app.name=SunBank
app.version=1.0
```

---

### 🧾 Example POJO for `@ConfigurationProperties`

```java
//'main class of application '
@EnableConfigurationProperties(value = AccountContactInfoDetailsDto.class)
public class AccountsApplication {

  public static void main(String[] args) {
    SpringApplication.run(AccountsApplication.class, args);
  }
}

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
public record AccountContactInfoDetailsDto(String massage, Map<String, String> contactDetails,
                                           List<String> onCallSupport) {

}


//
//accounts:
//    massage: "Welcome In SunBank ...!"
//    contactDetails:
//        name: "Prasun Patidar"
//        email: "codebysun@gmail.com"
//    onCallSupport:
//            - 88888-88888
//            - 99999-99999
//--------------
//OR
@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String name;
    private String version;

    // Getters and Setters
}
```

### 🧪 Configuration Examples in Context

```properties
application.properties=server.port=8080 
spring.datasource.url=jdbc:mysql://localhost:3306/mydb 
app.name=SunBank app.version=1.0
```

###  ✅ Example: @Value

```java 
import org.springframework.beans.factory.annotation.Value;

@Value("${app.name}")
private String appName;
```

###  ✅ Example:  Environment Interface

```java 
import org.springframework.core.env.Environment;

@Autowired
private Environment environment;

public String acctHealth() {
    return " Java-version : " + environment.getProperty("java.version");
}
```

## Provide  configuration form externally 
### some time we have not proper poisoning to edit the default application properties file before the run and build application, in this case, we can pass the configuration properties form externally.
### There are some common approches: -

#### 1. Command Line Approach (higher priority ):
```shell
java -jar .\accounts\target\accounts-0.0.1-SNAPSHOT.jar --spring.profiles.active="local"
```
#### 2. JVM / JAVA system properties (second most priority):
```shell
#For Run
java -Dspring.profiles.active=docker -DskipTests -jar .\accounts\target\accounts-0.0.1-SNAPSHOT.jar
#For Build
mvn clean compile install jib:dockerBuild -Dspring.profiles.active=docker -DskipTests 
```
#### 3. Environment Variables (3rd most priority / Mostly used approach):
- java based config : 
  - ```java
    //    First  method 
      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.core.env.Environment;
      import org.springframework.stereotype.Component;
      import jakarta.annotation.PostConstruct;
      
      @Component
      public class EnvConfig {
      
          @Autowired
          private Environment env;
      
          @PostConstruct
          public void init() {
              String dbUrl = env.getProperty("SPRING_DATASOURCE_URL", "jdbc:mysql://localhost:3306/defaultdb");
              String dbUser = env.getProperty("SPRING_DATASOURCE_USERNAME", "defaultUser");
              String dbPass = env.getProperty("SPRING_DATASOURCE_PASSWORD", "defaultPass");
      
              System.out.println("DB URL: " + dbUrl);
              System.out.println("DB User: " + dbUser);
              System.out.println("DB Pass: " + dbPass);
          }
      }
    
      // Second Method 
      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.core.env.Environment;
      import org.springframework.stereotype.Component;
      
      import jakarta.annotation.PostConstruct;
      
      @Component
      public class EnvConfig {
      
          @Autowired
          private Environment env;
      
          @PostConstruct
          public void init() {
              String dbUrl = env.getProperty("SPRING_DATASOURCE_URL", "jdbc:mysql://localhost:3306/defaultdb");
              String dbUser = env.getProperty("SPRING_DATASOURCE_USERNAME", "defaultUser");
              String dbPass = env.getProperty("SPRING_DATASOURCE_PASSWORD", "defaultPass");
      
              System.out.println("DB URL: " + dbUrl);
              System.out.println("DB User: " + dbUser);
              System.out.println("DB Pass: " + dbPass);
          }
      }   
    ``` 
  - Provide in command :
    ```shell
    #In Windows:
     env:SPRING_PROFILES_ACTIVE="local;java -jar .\accounts\target\accounts-0.0.1-SNAPSHOT.jar
    
    #In unix/linux:
     SPRING_PROFILES_ACTIVE="local;java -jar .\accounts\target\accounts-0.0.1-SNAPSHOT.jar
    ```


Spring cloud configuration 
  - git/path/classpath
  - encryption values in properties 
  - spring actuator to refresh the properties (trigger refresh api each service) - http://localhost:8080/actuator/refresh
  - Sping cloud bus (using rabbitmq and kafaka ) --(only one microservice busrefresh trigger )- http://localhost:8082/actuator/busrefresh
  - git hooks -> top of spring bus approach no needed to trigger automatically  it will automatically refresh when git got new update configuration




# 🌱 Spring Cloud Configuration Overview

Spring Cloud Config provides server-side and client-side support for externalized configuration in a distributed system. It allows you to manage configuration across all environments and microservices from a central Git repository.

---

## 📁 Configuration Sources

### 1. Git Repository

* Most common and recommended.
* Supports HTTP, SSH, and local file-based Git.

```yaml
spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/your-org/config-repo
          clone-on-start: true
          search-paths: config/*
```

**Dependencies**

**Gradle**

```gradle
implementation 'org.springframework.cloud:spring-cloud-config-server'
```

**Maven**

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

---

### 2. Classpath

* Useful for testing or embedded configurations.

```yaml
spring:
  cloud:
    config:
      server:
        native:
          search-locations: classpath:/config
```

**Dependencies**

**Gradle**

```gradle
implementation 'org.springframework.cloud:spring-cloud-config-server'
```

**Maven**

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

---

### 3. Filesystem Path

* For local development or mounted volumes.

```yaml
spring:
  cloud:
    config:
      server:
        native:
          search-locations: file:///path/to/config
```

**Dependencies**

**Gradle**

```gradle
implementation 'org.springframework.cloud:spring-cloud-config-server'
```

**Maven**

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

---

## 🔐 Encrypted Values in Properties

Spring Cloud Config supports encrypted values using a symmetric or asymmetric key.

### 1. Encrypting a Property

Use the `/encrypt` endpoint of the Config Server:

```bash
curl -X POST http://localhost:8888/encrypt -d 'my-secret-value'
```

This returns an encrypted string like:

```
{cipher}AQB3a...==
```

### 2. Decrypting on Client Side

```yaml
spring:
  cloud:
    config:
      server:
        encrypt:
          key: your-secret-key
```

Or use a keystore:

```yaml
encrypt:
  key-store:
    location: classpath:/keystore.jks
    password: changeit
    alias: mykey
```

**Dependencies**

**Gradle**

```gradle
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.springframework.cloud:spring-cloud-starter-config'
```

**Maven**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

---

## 🔄 Refreshing Properties with Spring Actuator

Each microservice can refresh its configuration manually via:

**Endpoint:**

```http
POST http://localhost:8080/actuator/refresh
```

**Enable refresh scope in code:**

```java
@RefreshScope
@Bean
public MyBean myBean() {
    return new MyBean();
}
```

**Dependencies**

**Gradle**

```gradle
implementation 'org.springframework.boot:spring-boot-starter-actuator'
implementation 'org.springframework.cloud:spring-cloud-starter-config'
```

**Maven**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

---

## 🚍 Spring Cloud Bus (RabbitMQ / Kafka)

Spring Cloud Bus links nodes in a distributed system with a lightweight message broker. It propagates configuration changes automatically.

**Configuration (Kafka Example):**

```yaml
spring:
  cloud:
    bus:
      enabled: true
    stream:
      kafka:
        binder:
          brokers: localhost:9092
```

**Configuration (RabbitMQ Example):**

```yaml
spring:
  cloud:
    stream:
      rabbit:
        binder:
          addresses: localhost:5672
```

**Trigger Bus Refresh (only one service):**

```http
POST http://localhost:8082/actuator/busrefresh
```

**Dependencies**

**Gradle**

```gradle
implementation 'org.springframework.cloud:spring-cloud-starter-bus-amqp'   // RabbitMQ
implementation 'org.springframework.cloud:spring-cloud-starter-bus-kafka' // Kafka
```

**Maven**

```xml
<!-- RabbitMQ -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>

<!-- Kafka -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-kafka</artifactId>
</dependency>
```

---

## 🪝 Git Hooks + Spring Cloud Bus

To automate refresh when Git updates:

### 1. Git Hook (Post-Commit or Post-Push)

Set up a hook in your Git repo to call the `/actuator/busrefresh` endpoint:

```bash
#!/bin/bash
curl -X POST http://localhost:8082/actuator/busrefresh
```

### 2. No Manual Trigger Needed

With Spring Cloud Bus and Git hooks, you don’t need to manually call `/refresh` on each service. The bus will propagate changes automatically.

**Dependencies**

(Same as Spring Cloud Bus section, plus Config Server)

---

## ✅ Summary Table

| Feature                | Description                                             | Dependency                                                     |
| ---------------------- | ------------------------------------------------------- | -------------------------------------------------------------- |
| Git / Path / Classpath | Centralized config source options                       | spring-cloud-config-server                                     |
| Encrypted Properties   | Secure sensitive values using `/encrypt` and `{cipher}` | spring-boot-starter-security, spring-cloud-starter-config      |
| Actuator Refresh       | Manual refresh via `/actuator/refresh`                  | spring-boot-starter-actuator, spring-cloud-starter-config      |
| Spring Cloud Bus       | Auto-propagates config changes via RabbitMQ/Kafka       | spring-cloud-starter-bus-amqp / spring-cloud-starter-bus-kafka |
| Bus Refresh Trigger    | Only one service needs `/actuator/busrefresh`           | spring-cloud-bus                                               |
| Git Hooks              | Automate refresh on Git update                          | spring-cloud-bus + config server                               |

---
##  Docker compose file  with all dependent apps (with #docker compose commands) :
```shell 

docker compose up -d
docker compose down -v
docker compose config
```
### docker-compose.yaml
```yaml
version: '3.8'


x-variables:
  rabbit_user: &rabbit_user guest
  rabbit_pass: &rabbit_pass guest
  rabbit_port: &rabbit_port 5672
  application_profile: &application_profile prod



services:
  mysql-app-db:
    image: mysql:8.0
    container_name: mysql-app-db
    restart: always
    environment:
      MYSQL_DATABASE: sunbank
      MYSQL_USER: user
      MYSQL_PASSWORD: docker123
      MYSQL_ROOT_PASSWORD: root
    ports:
      - "3306:3306"
    healthcheck:
      test: ["CMD-SHELL", "mysqladmin ping -h localhost || exit 1"]
      interval: 10s
      timeout: 10s
      retries: 10
    volumes:
      - mysql-data:/var/lib/mysql
    networks:
      - spring-app-ms-net

  rabbitmq:
    image: rabbitmq:latest
    container_name: rabbitmq
    ports:
      - "5672:5672"       # RabbitMQ messaging port
      - "15672:15672"     # RabbitMQ management UI
    environment:
      RABBITMQ_DEFAULT_USER: *rabbit_user
      RABBITMQ_DEFAULT_PASS: *rabbit_pass
    healthcheck:
      test: ["CMD", "rabbitmq-diagnostics", "ping"]
      interval: 10s
      timeout: 5s
      retries: 10
      start_period: 5s
    networks:
      - spring-app-ms-net

  configserver:
    image: codebysun/configserver:latest
    container_name: configserver
    depends_on:
      rabbitmq:
        condition: service_healthy
    ports:
      - "8071:8071"
    environment:
      RABBITMQ_HOST: rabbitmq
      RABBITMQ_PORT: *rabbit_port
      RABBITMQ_USERNAME: *rabbit_user
      RABBITMQ_PASSWORD: *rabbit_user
      SPRING_PROFILES_ACTIVE: git,prod
    healthcheck:
      test: ["CMD-SHELL", "curl -f http://localhost:8071/actuator/health/readiness | grep UP || exit 1"]
      interval: 10s
      timeout: 5s
      retries: 10
      start_period: 10s
    networks:
      - spring-app-ms-net

  accounts:
    image: codebysun/accounts:latest
    container_name: accounts
    depends_on:
      mysql-app-db:
        condition: service_healthy
      configserver:
        condition: service_healthy
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql-app-db:3306/sunbank?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
      SPRING_DATASOURCE_USERNAME: user
      SPRING_DATASOURCE_PASSWORD: docker123
      SPRING_DATASOURCE_DRIVER_CLASS_NAME: com.mysql.cj.jdbc.Driver
      SPRING_CONFIG_SERVER: configserver:http://configserver:8071/
      SPRING_PROFILES_ACTIVE: *application_profile
      RABBITMQ_HOST: rabbitmq
      RABBITMQ_PORT: *rabbit_port
      RABBITMQ_USERNAME: *rabbit_user
      RABBITMQ_PASSWORD: *rabbit_user
    #    entrypoint: ["/bin/sh", "-c", "echo Starting Account Application  && java -jar app.jar --spring.profiles.active=*application_profile"]
    networks:
      - spring-app-ms-net

  loans:
    image: codebysun/loans:latest
    container_name: loans
    depends_on:
      mysql-app-db:
        condition: service_healthy
      configserver:
        condition: service_healthy
    ports:
      - "8081:8081"
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql-app-db:3306/sunbank?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
      SPRING_DATASOURCE_USERNAME: user
      SPRING_DATASOURCE_PASSWORD: docker123
      SPRING_DATASOURCE_DRIVER_CLASS_NAME: com.mysql.cj.jdbc.Driver
      SPRING_CONFIG_SERVER: configserver:http://configserver:8071/
      SPRING_PROFILES_ACTIVE: *application_profile
      RABBITMQ_HOST: rabbitmq
      RABBITMQ_PORT: *rabbit_port
      RABBITMQ_USERNAME: *rabbit_user
      RABBITMQ_PASSWORD: *rabbit_user
    #    entrypoint: [ "/bin/sh", "-c", "echo Starting Loan Application  && java -jar app.jar --spring.profiles.active=*application_profile" ]
    networks:
      - spring-app-ms-net

  cards:
    image: codebysun/cards:latest
    container_name: cards
    depends_on:
      mysql-app-db:
        condition: service_healthy
      configserver:
        condition: service_healthy
    ports:
      - "8082:8082"
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql-app-db:3306/sunbank?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
      SPRING_DATASOURCE_USERNAME: user
      SPRING_DATASOURCE_PASSWORD: docker123
      SPRING_DATASOURCE_DRIVER_CLASS_NAME: com.mysql.cj.jdbc.Driver
      SPRING_CONFIG_SERVER: configserver:http://configserver:8071/
      SPRING_PROFILES_ACTIVE: *application_profile
      RABBITMQ_HOST: rabbitmq
      RABBITMQ_PORT: *rabbit_port
      RABBITMQ_USERNAME: *rabbit_user
      RABBITMQ_PASSWORD: *rabbit_user
    #    entrypoint: [ "/bin/sh", "-c", "echo Starting Card Application  && java -jar app.jar --spring.profiles.active=*application_profile" ]
    networks:
      - spring-app-ms-net

volumes:
  mysql-data:

networks:
  spring-app-ms-net:
    driver: bridge

```

