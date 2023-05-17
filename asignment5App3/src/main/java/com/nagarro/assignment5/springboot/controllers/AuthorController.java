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

import com.nagarro.assignment5.springboot.entities.Author;
import com.nagarro.assignment5.springboot.repository.AuthorRepository;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorRepository repo;
	
	@PostMapping(path="/author",consumes= {"application/json"})
	public Author addAuthor(@RequestBody Author author) 
	{	System.out.println("working");
		repo.save(author);
		return author;
		
	}
	
	@GetMapping(path="/author")
	public List<Author> listAllAuthor(){
		
		return repo.findAll();
		
	}
	
	@PutMapping(path="/author",consumes= {"application/json"})
	public void updateAuthor(@RequestBody Author author) {
		repo.save(author);
	}
	
	@RequestMapping(path="/author/{name}")
	public Optional<Author> searchAuthorById(@PathVariable("name") String name) {
		return repo.findById(name);
		
	}
	
	@DeleteMapping(path="/author/{name}")
	public void deleteAuthorById(@PathVariable("name") String name) {
		
		repo.deleteById(name);
	}
	
}
