package com.miraclesoft.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;


/*
 * Go to this link: http://localhost:8080/swagger-ui.html#!/greeting-controller/getGreetingUsingGET
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/app/user.*"), regex("/app/adduser.*"), regex("/app/userid/*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SpringBoot with Swagger2 App")
				.description("Spring Boot API reference for developers")
				.termsOfServiceUrl("http://localhost:8080/app/greeting?name=fun")
				.contact("prashant@miracle.com").license("Miracle Software Systems License")
				.licenseUrl("mms@miracle.com").version("1.0").build();
	}

}
