package com.nagarro.assignment5.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.assignment5.springboot.entities.User;
import com.nagarro.assignment5.springboot.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@PostMapping(path="/user",consumes= {"application/json"})
	public User addUser(@RequestBody User user) 
	{	System.out.println("working");
		repo.save(user);
		return user;
		
	}
	
	@GetMapping(path="/user")
	public List<User> listAllUser(){
		
		return repo.findAll();
		
	}
	
	@PutMapping(path="/user",consumes= {"application/json"})
	public void updateUser(@RequestBody User user) {
		repo.save(user);
	}
	
	@RequestMapping(path="/user/{name}")
	public Optional<User> searchUserById(@PathVariable("name") String username) {
		return repo.findById(username);
		
	}
	
	@DeleteMapping(path="/user/{name}")
	public void deleteUserById(@PathVariable("name") String username) {
//		Optional<User> a=repo.findById(username);
		repo.deleteById(username);
	}
	
}
