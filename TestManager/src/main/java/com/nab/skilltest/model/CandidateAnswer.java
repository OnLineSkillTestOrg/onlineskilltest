package com.nab.skilltest.model;

import java.util.List;

public class CandidateAnswer implements Comparable<CandidateAnswer>{
	
	int  questionID;
	List<String> selectedAnswers;
	String freeTextAnswer;
	boolean isCorrect;
	
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public List<String> getSelectedAnswers() {
		return selectedAnswers;
	}
	public void setSelectedAnswers(List<String> selectedAnswers) {
		this.selectedAnswers = selectedAnswers;
	}
	public String getFreeTextAnswer() {
		return freeTextAnswer;
	}
	public void setFreeTextAnswer(String freeTextAnswer) {
		this.freeTextAnswer = freeTextAnswer;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public int getFreeTextAnswerMarks() {
		return freeTextAnswerMarks;
	}
	public void setFreeTextAnswerMarks(int freeTextAnswerMarks) {
		this.freeTextAnswerMarks = freeTextAnswerMarks;
	}
	int freeTextAnswerMarks;

	@Override
	public int compareTo(CandidateAnswer o) {
		// TODO Auto-generated method stub
		return (this.questionID-o.getQuestionID());
	}
	

}
