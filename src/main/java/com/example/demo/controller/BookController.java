package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.pojo.Book;
import com.example.demo.repository.BookRepository;

@RestController
@RequestMapping(path = "/api/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(path="/getAll", produces = "application/json")
	@ResponseBody
	public String findAll() {
		return bookRepository.findAll().toString();
	}
	
	@RequestMapping(path = "/title/{bookTitle}"/* , produces = "application/json" */)
	public List<Book> findByTitle(@PathVariable String bookTitle) {
		return bookRepository.findByTitle(bookTitle);
	}
	
	@RequestMapping(path = "/{id}", produces = "application/json")
	public Book findById(@PathVariable Long id) throws BookNotFoundException {
//		return new Book(1,"Test","TestAuthor");
		return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
	}
	
}
