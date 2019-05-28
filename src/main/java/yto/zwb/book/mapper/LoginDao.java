package yto.zwb.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import yto.zwb.book.entity.User;

@Mapper
@Repository
public interface LoginDao{
	
	public List<User> toLogin(User user);
	
	public int toRegister(User user);
	
	public String findUserName(User user);

}
