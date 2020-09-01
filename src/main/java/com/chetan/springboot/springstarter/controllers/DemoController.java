package com.chetan.springboot.springstarter.controllers;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chetan.springboot.springstarter.model.Topic;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value ="Demo",description ="This section details the Demo APIs", position=1)
public class DemoController {
	
	Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@GetMapping("/")
	@ApiOperation(httpMethod = "GET",value = "To get Chetan Message",  notes = "API to load the Message for chetan", position=2)
	public String getMessage(){
		logger.info("Spring Boot App working fine..");
		return "Hey Chetan, Hows you doing ? This is your first springboot application";
	}
	
	@GetMapping(value="/topic", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET",value = "Topic Load",  notes = "API to load the Topic page",  response = Topic.class,position=1)
	public List<Topic> getMsg(){
		logger.info("topic API called : /topic");
		return Arrays.asList(new Topic("spring","Spring Framework","Spring framework discription"),
				new Topic("core java","core java j2se","core java discription"),
				new Topic("hibernate","Hibernate ORM Framework","Hibernate ORM framework discription"),
				new Topic("restful","Restful web service","Restful web service discription"));
	}
	
	@GetMapping("/admin")
	@ApiOperation(httpMethod = "GET",value = "To get Admin Message",  notes = "API to load the Message for admin", position=4)
	public String getAdminAccess(){
		logger.info("Logged in as ADMIN");
		return "Hey Admin, Hows you doing ? This is your first springboot application";
	}
	
	@GetMapping("/user")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Failed")})
	@ApiOperation(httpMethod = "GET",value = "To get User Message",  notes = "API to load the Message for User", position=3)
	public String getUserAccess(){
		logger.info("Logged in as USER");
		return "Hey User, Hows you doing ? This is your first springboot application";
	}

}
