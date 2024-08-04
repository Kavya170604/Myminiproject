package com.project1.Myapp.been;

import java.util.ArrayList;
import java.util.List;

public class BookDetails {
	private List<String> addData=new ArrayList();
	public void addBooks(String Books) {
		addData.add(Books);
	}
	public List<String> getBooks(){
		return new ArrayList<String>(addData);

}
}
