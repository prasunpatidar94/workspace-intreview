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
select * from sunbank.loan;
select * from sunbank.customer;
select * from sunbank.accounts;
```

## resizing attaches (approach to divide work in small pieces)
- domain driven design
- event driven design

## Strangler fig pattern 
- best to migrate from one big complex legacy application to microservices 
- identification -> transformation-> co-existence -> elimination

## Challenge #3 (deployment, scalability, Portability)
- solution id containerization (with docker and kubernetes)
- 


