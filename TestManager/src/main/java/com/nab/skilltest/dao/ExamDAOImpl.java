package com.nab.skilltest.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.nab.skilltest.model.CandidateAnswer;
import com.nab.skilltest.model.Exam;
import com.nab.skilltest.service.ExamService;
import com.nab.skilltest.ui.model.AnswerResponse;
import com.nab.skilltest.ui.model.Question;

@Repository("examDAO")
public class ExamDAOImpl implements ExamDAO {

	@Autowired
	@Qualifier("mongoTemplate")
	MongoTemplate mongoOperation;

	@Override
	public void saveExam(Exam exam) {
		mongoOperation.save(exam);
	}

	@Override
	public Exam retrieveExam(int examID) {
		
		Query searchUserQuery = new Query(Criteria.where("id").is(examID));
		Exam exam =mongoOperation.findOne(searchUserQuery, Exam.class);
		Collections.sort(exam.getMyAnswers());
		return exam;
	}
	
	@Override
	public int getTotalExam(){
		
		return mongoOperation.findAll(Exam.class).size();
	}

	@Override
	public void updateExam(Exam exam,AnswerResponse answer) {
		Query query = new Query(Criteria.where("id").is(exam.getId()));
		Update update = new Update();
		for(CandidateAnswer canAns:exam.getMyAnswers()){
			if(canAns.getQuestionID()==answer.getQuestionId()){
				canAns.setSelectedAnswers(answer.getSelectedAnswers());
			}
		}
		update.set("myAnswers", exam.getMyAnswers());
		mongoOperation.updateFirst(query, update, Exam.class);
	}
	
	
}
