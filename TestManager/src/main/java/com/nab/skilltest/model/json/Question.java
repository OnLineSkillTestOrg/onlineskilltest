package com.nab.skilltest.model.json;

import java.util.List;

public class Question {
	
	String questionText;
	String questionId;
	String questionType;
	List<AnswerOptions> answers;
	
	
	String previousQuestion;
	String nextQuestion;
	

}
