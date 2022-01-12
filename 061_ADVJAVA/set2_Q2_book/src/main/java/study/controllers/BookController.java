package study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.dao.BookDAOBean;
import study.entity.BookEntity;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookDAOBean dao;
	
	@PostMapping("/add/{id}/{cost}/{name}")
	public void insertbook(@PathVariable int id, @PathVariable int cost, @PathVariable String name) 
	{
		dao.addBook(id, cost, name);
	}
	
	@GetMapping("/getAll")
	public List<BookEntity> getBooks()
	{
		return dao.getBooks();
	}
	
}
