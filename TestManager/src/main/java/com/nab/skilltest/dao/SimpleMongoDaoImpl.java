package com.nab.skilltest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nab.skilltest.model.User;
@Repository("myMongoDAO")
public class SimpleMongoDaoImpl implements SimpleMongoDao {
	
	@Autowired
	@Qualifier("mongoTemplate")
	MongoTemplate mongoOperation;
	
	public MongoTemplate getMongoOperation() {
		return mongoOperation;
	}

	public void setMongoOperation(MongoTemplate mongoOperation) {
		this.mongoOperation = mongoOperation;
	}

	public User getUser(int id) {
		Query searchUserQuery = new Query(Criteria.where("id").is(id));
		User user = mongoOperation.findOne(searchUserQuery, User.class);
		System.out.println("Retrieved user : "+user.getName());
		return user;
	}
	
	public User saveUser(User user) {
		
		List<User> list =mongoOperation.findAll(User.class);
		user.setId(list.size()+1);
		mongoOperation.save(user);
		System.out.println("Saved user : "+user.getName());
		return user;
	}

}
