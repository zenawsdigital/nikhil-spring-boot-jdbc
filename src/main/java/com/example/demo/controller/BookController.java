package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(path="/getAll", produces = "application/json")
	@ResponseBody
	public String findAll() {
		return bookRepository.findAll().toString();
	}
	
	@GetMapping(path = "/title/{bookTitle}"/* , produces = "application/json" */)
	public List<Book> findByTitle(@PathVariable String bookTitle) {
		return bookRepository.findByTitle(bookTitle);
	}
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public Book findById(@PathVariable Long id) throws BookNotFoundException {
//		return new Book(1,"Test","TestAuthor");
		return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
	}
	
	@PostMapping(path = "/createBook",consumes = "application/json")
	public Book createBook(@Valid @RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@PostMapping(path = "/updateBook/{id}")
	public Book updateBook(@PathVariable Long id,@Valid @RequestBody Book book) throws BookNotFoundException {
		Book oldBook = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
		
		oldBook.setTitle(book.getTitle());
		oldBook.setAuthor(book.getAuthor());
		
		Book updatedBook = bookRepository.save(oldBook);
		
		return updatedBook;
	}
	
	@DeleteMapping(path ="/deleteBook/{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable Long id) throws BookNotFoundException {
		Book oldBook = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
		
		bookRepository.delete(oldBook);
		
		return ResponseEntity.ok().build();
	}
	
}
