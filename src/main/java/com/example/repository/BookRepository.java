package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.pojo.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	List<String> findByTitle(String title);
}
