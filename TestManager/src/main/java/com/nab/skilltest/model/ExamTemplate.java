package com.nab.skilltest.model;

import java.util.List;

public class ExamTemplate {
	
	String id;
	String candidateInstructions;
	List<QuestionTemplate> questionsTypes;
	int duration;
	public String getJd() {
		return id;
	}
	public void setJd(String jd) {
		this.id = jd;
	}
	public String getCandidateInstructions() {
		return candidateInstructions;
	}
	public void setCandidateInstructions(String candidateInstructions) {
		this.candidateInstructions = candidateInstructions;
	}
	public List<QuestionTemplate> getQuestionsTypes() {
		return questionsTypes;
	}
	public void setQuestionsTypes(List<QuestionTemplate> questionsTypes) {
		this.questionsTypes = questionsTypes;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	

}
