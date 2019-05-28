package yto.zwb.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yto.zwb.book.entity.User;
import yto.zwb.book.mapper.LoginDao;
import yto.zwb.book.service.LoginService;

@Service("LoginService")
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginDao loginDao;

    public boolean toLogin(User user){

        List<User> userList = loginDao.toLogin(user);
         return userList.size()>0;
     }
    
    public Integer  toRegister(User user) {
    	return loginDao.toRegister(user);
    }
    
    public String findUserName(User user) {
    	return loginDao.findUserName(user);
    }
    
    

}





