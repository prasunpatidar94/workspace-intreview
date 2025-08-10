package com.sun.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

 // to enable jpa auditing with or custom configuration
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loan Microservice Rest API Documentation",
				description = "SunBank Loan Microservice Rest API Documentation",
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
				description = "SunBank Loan Microservices Rest API Documentation",
				url = "https://sunbank.com/details"
		)
)
@SpringBootApplication
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
