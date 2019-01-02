package com.java.dao;

import com.java.entity.User;

import java.util.List;

public interface UserDao {

	public User login(User user);
	
	public User add(User user);

	public User getUserFromId(int id);

	public List<User> getUsers();
}
