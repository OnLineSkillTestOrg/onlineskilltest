package com.nab.skilltest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nab.skilltest.model.Question;


@Repository("questionDAO")
public class QuestionDAOImpl implements QuestionDAO {

	
	@Autowired
	@Qualifier("mongoTemplate")
	MongoTemplate mongoOperation;
	
	@Override
	public Question retrieveQuestion(int qID) {
		// TODO Auto-generated method stub
		Query searchUserQuery = new Query(Criteria.where("id").is(qID));
		Question q=mongoOperation.findOne(searchUserQuery, Question.class);
		return q;
	}

	@Override
	public int getTotalQuestion() {
		return mongoOperation.findAll(Question.class).size();
	}
	
	@Override
	public void save(com.nab.skilltest.model.Question question) {
		mongoOperation.save(question);
		
	}
	
	

}
