package yto.zwb.book.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import yto.zwb.book.entity.book;

@Mapper
@Repository
public interface BookDao {
	
	 public List<book> getBookList();
		
	 public int insert(book book);
	 
	 public int update(book book);
	 
	 public int delete(Integer Id);
	 
	 public book getBookById(Integer Id);
	 
	 public List<book> findBook(String book);
	

	 

	 

}
