package yto.zwb.book.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Configuration
	/*
	  WebSecurityConfig类继承WebMvcConfigurationSupport，有三个方法：preHandle、postHandle、afterCompletion
	  preHandle在业务处理器处理请求之前被调用，可以进行编码、安全控制等处理；
	  postHandle在业务处理器处理请求执行完成后，生成视图之前执行；
	  afterCompletion在DispatcherServlet完全处理完请求后被调用，可用于清理资源等；
	*/
public class WebSecurityConfig extends WebMvcConfigurationSupport{
	
	//登陆session_key
	public final static String SESSION_KEY="session";
	
	 @Bean
	    public SecurityInterceptor getSecurityInterceptor(){
	        return new SecurityInterceptor();	        
	    }
	 
	 //重写addInterceptors方法，其目的是设置拦截规则
	 public void  addInterceptors(InterceptorRegistry registry){
	        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

	        //excludePathPatterns为需要排除的规则，addPathPatterns为需要拦截的规则。
	        addInterceptor.excludePathPatterns("/error");
	        addInterceptor.excludePathPatterns("/login");
	        addInterceptor.excludePathPatterns("/insert");

	        //拦截全部
	        //addInterceptor.addPathPatterns("/**");
	        
	        addInterceptor.addPathPatterns("/index");
	        addInterceptor.addPathPatterns("/bookFind");
	        addInterceptor.addPathPatterns("/bookAdd");
	        addInterceptor.addPathPatterns("/bookUpdate");
	        
	    }

//SecurityInterceptor类继承HandlerInterceptorAdapter，并重新preHandle方法，对请求进行session判断和跳转到自定义的页面
	    private class SecurityInterceptor extends HandlerInterceptorAdapter{
	        @Override
	        public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException {
	            HttpSession session = request.getSession();

//	            判断是否已有该用户登录的session
	            if(session.getAttribute(WebSecurityConfig.SESSION_KEY) != null){
	                return true;
	            }

//	            跳转到登录页
	            String url = "/login";
	            response.sendRedirect(url);
	            return false;
	        }
	    }
	    
}	    


