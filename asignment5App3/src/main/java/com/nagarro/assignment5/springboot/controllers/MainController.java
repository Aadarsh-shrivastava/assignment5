package com.nagarro.assignment5.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController{
	@RequestMapping("/home")
	public String home() {
		
		return "welcome to home page chalta hai bc";
	}
}
