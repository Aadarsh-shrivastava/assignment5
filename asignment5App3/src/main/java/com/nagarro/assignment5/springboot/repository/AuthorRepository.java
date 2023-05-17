package com.nagarro.assignment5.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.assignment5.springboot.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,String>{

}
