
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
docker run --name mysql-container \
-e MYSQL_ROOT_PASSWORD=rootpass \
-e MYSQL_DATABASE=sunbank \
-e MYSQL_USER=user \
-e MYSQL_PASSWORD=pass123 \
-p 3306:3306 \
-d mysql:8.0
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
SELECT * FROM sunbank.loan;
SELECT * FROM sunbank.customer;
SELECT * FROM sunbank.accounts;
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

| No | Configuration Source                             |
|----|--------------------------------------------------|
| 1  | Command Line Arguments                           |
| 2  | `ServletConfig` init Parameters                  |
| 3  | `ServletContext` init Parameters                 |
| 4  | JNDI attributes from `java:comp/env`             |
| 5  | Java System Properties (`System.getProperties()`)|
| 6  | OS Environment Variables                         |
| 7  | `application.properties` file                    |

### we will cover merger 3 used approached 
### 📊 Configuration Approaches in Spring Boot

| No | Approach                     | Example                                                                                                        | Drawbacks                                                                                           |
|----|------------------------------|---------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------|
| 1  | `@Value` Annotation          | `@Value("${server.port}")`<br>Injects single property directly into a field                                   | ❌ Hard to manage multiple related properties<br>❌ No support for complex object binding             |
| 2  | `Environment` Class          | `env.getProperty("spring.datasource.url")`<br>Use inside constructor or method to fetch property dynamically  | ❌ Not type-safe<br>❌ Needs manual conversion and default handling                                   |
| 3  | `@ConfigurationProperties`   | `@ConfigurationProperties(prefix = "app")`<br>Maps `app.*` properties into a POJO                            | ❌ Requires getter/setter<br>❌ Needs class to be annotated with `@Component` or registered manually |


### 🔍 Quick Comparison

| Feature                         | `@Value`               | `Environment`            | `@ConfigurationProperties`        |
|---------------------------------|------------------------|---------------------------|------------------------------------|
| ✅ Type-safety                  | ❌ No                  | ❌ No                      | ✅ Yes                             |
| ✅ Complex object mapping       | ❌ No                  | ❌ No                      | ✅ Yes                             |
| ✅ Ease of testing              | ❌ Hardcoded values     | ⚠️ Requires mocking        | ✅ Clean POJOs                     |
| ✅ Spring Boot friendly         | ✅ Simple usage         | ⚠️ Utility-based access     | ✅ Highly recommended              |

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
application.properties server.port=8080 
spring.datasource.url=jdbc:mysql://localhost:3306/mydb 
app.name=SunBank app.version=1.0
```
✅ Example: @Value
```java 
@Value("${app.name}")
private String appName;
```
