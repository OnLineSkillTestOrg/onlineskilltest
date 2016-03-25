package com.nab.skilltest.dao;

import com.nab.skilltest.model.Question;



public interface QuestionDAO {
	
	public Question retrieveQuestion(int qID);
	
	public int getTotalQuestion();

	public void save(Question question);
}
