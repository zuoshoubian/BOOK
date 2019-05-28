package yto.zwb.book.service;

import yto.zwb.book.entity.User;

public interface LoginService {
	
	public boolean toLogin(User user);
	
	public Integer  toRegister(User user);
	
	public String findUserName(User user);

}
