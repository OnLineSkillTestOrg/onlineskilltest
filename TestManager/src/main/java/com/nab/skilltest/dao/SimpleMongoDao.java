package com.nab.skilltest.dao;

import com.nab.skilltest.model.User;

public interface SimpleMongoDao {
	
	public User getUser(int id);
	public User saveUser(User user);
}
