package yto.zwb.book.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yto.zwb.book.entity.book;
import yto.zwb.book.service.BookService;


@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	 
	 @GetMapping("/index")
	 @ModelAttribute
	    public String getBookList(Model model,@RequestParam(value="start",defaultValue="0")int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		 	PageHelper.startPage(start,size);
		 	List<book> books=bookService.getBookList();
	        PageInfo<book> page = new PageInfo<>(books);
	        model.addAttribute("page", page);
	        return "/index";
	    }
		
	 @RequestMapping("/toInsert")
	    public String Insert() {
	        return  "/bookAdd";
	    }
	 @RequestMapping("/insert")
	 public String insert(book book) {
	        bookService.insert(book);
	        return "redirect:/index";
	 }
	 
	 
	 	@RequestMapping("/toUpdate")
	    public String getBookById(Model model,Integer id) {	
	        book book = bookService.getBookById(id);
	        model.addAttribute("book", book);
	        return "bookUpdate";
	    }
	    @RequestMapping("/update")
	    public String update(book book) {
	        bookService.update(book);
	        return "redirect:/index";
	    }
	    
	    
	    @GetMapping("/delete")
	    public String delete(Integer id) {
	        bookService.delete(id);
	        return "redirect:/index";
	    }
	    

		@RequestMapping("/get")
	    public String findBook(Model model,String id ) {	
	        List<book> books = bookService.findBook(id);
	        model.addAttribute("book", books);
	        return "/bookFind";
	    }		
}

