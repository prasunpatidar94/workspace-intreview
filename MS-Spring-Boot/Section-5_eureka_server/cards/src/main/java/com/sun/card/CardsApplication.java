package com.sun.card;

import com.sun.card.dto.CardsContactInfoDetailsDto;
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
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = CardsContactInfoDetailsDto.class)
@OpenAPIDefinition(
		info = @Info(
				title = "Card Microservice Rest API Documentation",
				description = "SunBank Card Microservice Rest API Documentation",
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
				description = "SunBank Card Microservices Rest API Documentation",
				url = "https://sunbank.com/details"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
