package yto.zwb.book.service;

import java.util.List;


import yto.zwb.book.entity.book;


public interface BookService {
	
	public List<book> getBookList();
	 
	 public book getBookById(Integer Id);
	
	 public int insert(book book);
	 
	 public int update(book book);
	 
	 public int delete(Integer Id);
	 
	 public List<book> findBook(String book);
	 
	
	 

	 
	 

}
