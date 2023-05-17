package com.nagarro.assignment5.controller;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignment5.Services.AuthorService;
import com.nagarro.assignment5.Services.UserService;

@Controller
public class UserController {
	
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
		return new ModelAndView("login");
	}

	@RequestMapping(value="/loginCheck")
	public ModelAndView loginCheck(HttpServletRequest request,HttpServletResponse response) throws IOException{
		UserService bs=new UserService();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(bs.validateUser(username,  password)==true) {
			System.out.println("he got validated"+bs.validateUser(username, password));
			HttpSession session=request.getSession();  
	        session.setAttribute("current-user",username);  
			return new ModelAndView("listBooks");
			}
		
		return new ModelAndView("login");
	}
	
}
