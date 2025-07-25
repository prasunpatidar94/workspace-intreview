#### Swagger URI	
```http://localhost:8080/swagger-ui/index.html```

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

