package com.cts.skilltest.model;

import java.util.Date;
import java.util.List;

public class Exam {
	
	long id;
	Date dateTime;
	Date startTime;
	Date endTime;
	//TODO more details
	
	List<CandidateAnswer> myAnswers;
	int score;
	String evaluatorRemarks;
	boolean manualEvaluationComplete;
	
	ExamTemplate template;

}
