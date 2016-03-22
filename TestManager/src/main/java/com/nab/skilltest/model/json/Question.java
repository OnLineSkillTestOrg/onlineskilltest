package com.nab.skilltest.model.json;

import java.util.List;

public class Question {
	
	int totalCount;
	int answerCount;
	
	String questionText;
	String questionId;
	String questionSequenceNumber;
	String questionType;
	List<AnswerOptions> answers;
	
	
	String previousQuestion;
	String nextQuestion;
	

}
