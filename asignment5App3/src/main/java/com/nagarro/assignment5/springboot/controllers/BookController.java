package com.nagarro.assignment5.springboot.controllers;

import org.springframework.web.bind.annotation.RestController;



import java.util.List;

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
import com.nagarro.assignment5.springboot.entities.Book;
import com.nagarro.assignment5.springboot.repository.AuthorRepository;
import com.nagarro.assignment5.springboot.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	BookRepository repo;
	
	@PostMapping(path="/book",consumes= {"application/json"})
	public Book addBook(@RequestBody Book book) 
	{	System.out.println("working");
		repo.save(book);
		return book;
		
	}
	
	@GetMapping(path="/book")
	public List<Book> listAllBook(){
		
		return repo.findAll();
		
	}
	
	@PutMapping(path="/book",consumes= {"application/json"})
	public void updateBook(@RequestBody Book book) {
		repo.save(book);
	}
	
	@RequestMapping(path="/book/{name}")
	public Book searchBookById(@PathVariable("name") int code) {
		return repo.getById(code);
		
	}
	
	@DeleteMapping(path="/book/{name}")
	public void deleteBookById(@PathVariable("name") int code) {
		Book a=repo.getById(code);
		repo.delete(a);
	}
	
}
