package com.nagarro.assignment5.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.assignment5.springboot.entities.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

}
