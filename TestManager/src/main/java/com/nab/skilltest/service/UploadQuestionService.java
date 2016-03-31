package com.nab.skilltest.service;

import java.util.List;

import com.nab.skilltest.model.Question;

public interface UploadQuestionService {
	
	public void uploadQuestion(String fileLocation);
	
	public Question getQuestionById(String questionId);
	
	public List<Question> getAll();

}