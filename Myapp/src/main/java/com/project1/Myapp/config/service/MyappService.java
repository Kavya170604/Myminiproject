package com.project1.Myapp.config.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.Myapp.been.Book;

@Service
public class MyappService {
	public String Display(){
		return "Spring action";
	}
	private final Book book;
	@Autowired

	public MyappService(Book book) {
		super();
		this.book=book;
		// TODO Auto-generated constructor stub
	}
	
	
public void addBooks(String addbooks) {
	book.addBooks(addbooks);
}
public List<String> getBooksDetails(){
	return book.getBooks();
}
}
