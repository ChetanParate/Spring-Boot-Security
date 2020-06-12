package com.chetan.springboot.springbootstarter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("com.chetan.springboot.springstarter")
@SpringBootApplication
@EnableSwagger2
public class SpringbootstarterApplication {

	private static Logger logger = LoggerFactory.getLogger(SpringbootstarterApplication.class);
	
	public static void main(String[] args) {
		
		logger.info("Spring boot application starting....");
		SpringApplication.run(SpringbootstarterApplication.class, args);
		logger.info("Spring boot application started....");
	}
	
	@Bean
	public Docket sawggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.chetan.springboot.*"))
				.build();
	}

}
