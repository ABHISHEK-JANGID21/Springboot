package com.message.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket SwaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				  .apiInfo(apiDetails())
				  .select()
				  .paths(PathSelectors.any())
				  .apis(RequestHandlerSelectors.basePackage("com.message.controller"))
				  .build();
	}
	private ApiInfo apiDetails() {
		 return new ApiInfoBuilder()
			      .title("") 
			      .description("")
			      .termsOfServiceUrl("https://fakeservice.com")
			      .contact(new Contact("Abhishek Jangid ", " https://fakeservice.com" , "fakemail@gmail.com "))
			      .license("license")
			      .licenseUrl("https://fakeLicense.com")
			      .version("1.0")
				  .build();
	}
}