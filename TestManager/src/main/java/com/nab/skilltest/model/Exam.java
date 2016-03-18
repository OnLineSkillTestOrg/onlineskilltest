package com.nab.skilltest.model;

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
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public List<CandidateAnswer> getMyAnswers() {
		return myAnswers;
	}

	public void setMyAnswers(List<CandidateAnswer> myAnswers) {
		this.myAnswers = myAnswers;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getEvaluatorRemarks() {
		return evaluatorRemarks;
	}

	public void setEvaluatorRemarks(String evaluatorRemarks) {
		this.evaluatorRemarks = evaluatorRemarks;
	}

	public boolean isManualEvaluationComplete() {
		return manualEvaluationComplete;
	}

	public void setManualEvaluationComplete(boolean manualEvaluationComplete) {
		this.manualEvaluationComplete = manualEvaluationComplete;
	}

	public ExamTemplate getTemplate() {
		return template;
	}

	public void setTemplate(ExamTemplate template) {
		this.template = template;
	}



}
