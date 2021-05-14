package com.zfliu.gson.es.controller;

import com.zfliu.gson.es.model.Book;
import com.zfliu.gson.es.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by zfliu on 2021/5/14 11:10
 * Desc:
 */
@RestController
@RequestMapping("/book")
public class BookController
{
	@Autowired
	BookRepository bookRepository;

	@PostMapping(value = "/add")
	public ResponseEntity<String> indexDoc(@RequestBody Book book) {
		book.setCreateTime(new Date());
		book.setUpdateTime(new Date());
		System.out.println("book===" + book);
		bookRepository.save(book);
		return new ResponseEntity<>("save executed!", HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<Iterable<Book>> getAll() {
		Iterable<Book> all =  bookRepository.findAll();
		return new ResponseEntity<>(all, HttpStatus.OK);
	}

	@GetMapping(value = "/{name}")
	public ResponseEntity<Book> getByName(@PathVariable("name") String name) {
		Book book = bookRepository.findByName(name);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") String id,
			@RequestBody Book updateBook) {
		Book book = bookRepository.findBookById(id);
		book.setId(updateBook.getId());
		book.setName(updateBook.getName());
		book.setAuthor(updateBook.getAuthor());
		book.setPrice(updateBook.getPrice());
		book.setUpdateTime(new Date());
		bookRepository.save(book);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") String id) {
		bookRepository.deleteById(id);
		return new ResponseEntity<>("delete execute!", HttpStatus.OK);
	}

}
