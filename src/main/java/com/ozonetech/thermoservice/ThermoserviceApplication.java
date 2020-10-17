package com.ozonetech.thermoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class ThermoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThermoserviceApplication.class, args);
	}

//	http://www.localhost:8080/swagger-ui.html

	@Bean
	public Docket SwaggerConfiguration(){
         return new Docket(DocumentationType.SWAGGER_2)
				 .select()
				 .paths(PathSelectors.ant("/api/users/*"))
				 .apis(RequestHandlerSelectors.basePackage("com.ozonetech.thermoservice"))
				 .build()
				 .apiInfo(apiDetails());

	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Thermometer Service API",
				"Sample API for thermometer service",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Felix Archibong","http://felixcity.herokuapp.com","felixarchibong@gmail.com"),
				"API License",
				"https://thermoservice.herokuapp.com",
				Collections.emptyList()
		);

	}
}
