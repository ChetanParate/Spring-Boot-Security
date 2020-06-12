package com.chetan.springboot.springstarter.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/home")
@Api(value ="Home",description ="This section details the Home APIs", position=2)
public class HomeResourceController {
	
	
	@GetMapping("/")
	@ApiOperation(httpMethod = "GET",value = "Load home",  notes = "API to load the Home page", position=1)
	public String getHome() {
		return ("<h1> Welcome Home </h1>");
	}
	@GetMapping("/user/home")
	@ApiOperation(httpMethod = "GET",value = "Load User Home",  notes = "API to load the user Home page",position=2)
	public String getUser() {
		return ("<h1> Welcome User Home </h1>");
	}
	@GetMapping("/admin/home")
	@ApiOperation(httpMethod = "GET",value = "Load Admin Home",  notes = "API to load the Admin Home page",position=3)
	public String getAdmin() {
		return ("<h1> Welcome Admin Home </h1>");
	}

}
