package yto.zwb.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import yto.zwb.book.entity.book;
import yto.zwb.book.mapper.BookDao;
import yto.zwb.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	 public List<book> getBookList(){
		 
		 return bookDao.getBookList();
	 }
	 @Override	
	 public int insert(book book) {
		 
		 return bookDao.insert(book);
	 }
	 @Override
	 public int update(book book) {
		 
		 return bookDao.update(book);
	 }
	 @Override
	 public int delete(Integer Id) {
		 
		 return bookDao.delete(Id);
	 }
	 @Override
	 public book getBookById(Integer Id) {
		 
		 return bookDao.getBookById(Id);
	 }
	 
	 public List<book> findBook(String book) {
		 return bookDao.findBook(book);
	 }
	 
	 
	

	    

	


}
