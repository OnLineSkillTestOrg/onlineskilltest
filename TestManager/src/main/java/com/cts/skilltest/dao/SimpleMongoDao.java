package com.cts.skilltest.dao;

import com.cts.skilltest.model.User;

public interface SimpleMongoDao {
	
	public User getUser(int id);
	public User saveUser(User user);
}
