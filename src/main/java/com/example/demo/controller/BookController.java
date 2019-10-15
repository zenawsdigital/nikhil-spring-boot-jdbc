package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.exception.BookNotFoundException;
import com.example.pojo.Book;
import com.example.repository.BookRepository;

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
	
	@RequestMapping("/title/{bookTitle}")
	public List findByTitle(@PathVariable String bookTitle) {
		return bookRepository.findByTitle(bookTitle);
	}
	
	@RequestMapping("/{id}")
	public Book findById(@PathVariable Long id) throws BookNotFoundException {
		return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
	}
	
}
