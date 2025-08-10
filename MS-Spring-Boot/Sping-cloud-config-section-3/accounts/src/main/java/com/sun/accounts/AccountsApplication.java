package com.sun.accounts;

import com.sun.accounts.dto.AccountContactInfoDetailsDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// if your keep all classes outside the base package the needed to use blow 3 annotation config to scan the external component
//@ComponentScans({@ComponentScan("com.pp.sun.controller")})
//@EnableJpaRepositories("com.pp.repo")
//@EntityScan("com.pp.entity")
@EnableConfigurationProperties(value = AccountContactInfoDetailsDto.class)
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")  // to enable jpa auditing with or custom configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Account Microservice Rest API Documentation",
                description = "SunBank Account Microservice Rest API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Prasun Patidar",
                        email = "codebysun@gmail.com",
                        url = "codebysun.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.codebysun.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "SunBank Account Microservices Rest API Documentation",
                url = "https://sunbank.com/details"
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
