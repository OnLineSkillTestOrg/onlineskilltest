package com.nab.skilltest.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Exam {
	
	@Id
	int id;
	Date dateTime;
	Date startTime;
	Date endTime;
	//TODO more details
	Candidate candidate;
	
	List<CandidateAnswer> myAnswers;
	int score;
	String evaluatorRemarks;
	boolean manualEvaluationComplete;
	
	ExamTemplate template;
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

}
