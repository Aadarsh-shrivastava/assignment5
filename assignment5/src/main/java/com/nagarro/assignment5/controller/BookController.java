package com.nagarro.assignment5.controller;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignment5.Entities.Book;
import com.nagarro.assignment5.Services.BookService;

@Controller
public class BookController {

	@RequestMapping(value="/getBooks")
	public ModelAndView getBook(HttpServletResponse response) throws IOException{
		BookService bs=new BookService();
		bs.getAllBooks();
		return new ModelAndView("home");
	}
	
	@GetMapping(value="/deleteBook")
	public ModelAndView deleteBook(ServletRequest request,HttpServletResponse response) throws IOException{
		int bookCode=Integer.parseInt(request.getParameter("BookCode"));
		BookService bs=new BookService();
		bs.deleteBook(bookCode);
		return new ModelAndView("listBooks");
	}
	
	@RequestMapping(value="/addBookPage")
	public ModelAndView addBookForm(ServletRequest request ,HttpServletResponse response) throws IOException{
		return new ModelAndView("addBook");
	}
	@GetMapping(value="/editBookPage")
	public ModelAndView editBookForm(ServletRequest request ,HttpServletResponse response) throws IOException{
		int bookCode=Integer.parseInt(request.getParameter("BookCode"));
		ModelAndView mv=new ModelAndView();
		mv.addObject("BookCode",bookCode);
		return new ModelAndView("editBook");
	}
	
	@RequestMapping(value="/addBook")
	public ModelAndView saveBook(ServletRequest request ,HttpServletResponse response) throws IOException{
		int bookCode=Integer.parseInt(request.getParameter("BookCode"));
		String bookName=request.getParameter("BookName");
		String author=request.getParameter("Author");
		String addedon=request.getParameter("Addedon");
		
		BookService bs=new BookService();
		Book bk=new Book(bookCode,bookName,author,addedon);
		bs.saveBook(bk, "POST");
		return new ModelAndView("listBooks");
	}
	@RequestMapping(value="/editBook")
	public ModelAndView updateBook(ServletRequest request ,HttpServletResponse response) throws IOException{
		int bookCode=Integer.parseInt(request.getParameter("BookCode"));
		String bookName=request.getParameter("BookName");
		String author=request.getParameter("Author");
		String addedon=request.getParameter("Addedon");
		
		BookService bs=new BookService();
		Book bk=new Book(bookCode,bookName,author,addedon);
		bs.saveBook(bk, "POST");
		return new ModelAndView("listBooks");
	}
}
