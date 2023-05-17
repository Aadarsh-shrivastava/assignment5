package com.nagarro.assignment5.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignment5.Services.AuthorService;

@Controller
public class AuthorController {

	@RequestMapping(value="/getAuthors")
	public ModelAndView getAuthor(HttpServletResponse response) throws IOException{
		AuthorService bs=new AuthorService();
		bs.getAllAuthors();
		return new ModelAndView("home");
	}
	
}
