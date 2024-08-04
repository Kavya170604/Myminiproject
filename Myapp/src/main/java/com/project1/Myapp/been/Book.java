package com.project1.Myapp.been;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Book {
	private final List books=new ArrayList();
	public void addBooks(String book) {
		books.add(book);
	}
	public List<String> getBooks(){
		return new ArrayList<String>(books);

}

}
