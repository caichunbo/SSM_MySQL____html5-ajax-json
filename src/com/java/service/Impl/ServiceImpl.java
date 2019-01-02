package com.java.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.UserDao;
import com.java.entity.User;
import com.java.service.UserService;

import java.util.List;

@Service("userService")
public class ServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	public User login(User user) {
		return userDao.login(user);
	}

	public User add(User user) {
		return userDao.add(user);
	}

	public User getUserFromId(int id){
		return userDao.getUserFromId(id);
	}

	public List<User> getUsers(){
		return userDao.getUsers();
	}

}
