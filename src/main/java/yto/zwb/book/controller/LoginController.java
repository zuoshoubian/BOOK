 package yto.zwb.book.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yto.zwb.book.entity.User;
import yto.zwb.book.login.WebSecurityConfig;
import yto.zwb.book.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	  @GetMapping("/")
	    public String index(HttpSession session,Model model){
		  Object object = session.getAttribute(WebSecurityConfig.SESSION_KEY);
            model.addAttribute("name" ,object);
	        return "login";
	    }
	
	  @GetMapping("/login")
	    public String login(){
	        return "login";
	    }
  
	  @PostMapping("/toLogin")
	//对登录请求到数据库中进行验证用户名和密码，验证通过以后设置session，否则跳转到登录页面
	    public String toLogin(String username,String password,HttpSession session){
	        User user = new User();
	        user.setUserName(username);
	        user.setPassword(password);
	        boolean go = loginService.toLogin(user);
	        if (go) {
	            session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
	            return "redirect:/index";
	        } else {
	            return "redirect:/login";
	        }
	    }
	  
		 @RequestMapping("/register")
		    public String Insert() {
		        return  "/insertUser";
		    }
		 @RequestMapping("/toRegister")
		    public String register(HttpServletRequest request){
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");
		        String password2 = request.getParameter("password2");
		        if (username != null) {
		        	return "/insertUser";
		        	}else if (password.equals(password2)) {
		        		User user = new User();
		        		user.setUserName(username);            
		        		user.setPassword(password);
		        		loginService.toRegister(user);
		        		return "redirect:/login";
		        	} else {
		        		return "/insertUser";
		        	}	
		 		      	        		
		 }		        
		
	    @GetMapping("/logout")
	    public String logout(HttpSession session){
	        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
	        return "redirect:/login";
	    }
	}

	
	


