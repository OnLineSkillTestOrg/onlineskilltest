package com.nab.skilltest.model;

import java.util.List;

public class CandidateAnswer {
	
	int  questionID;
	List<ChoiceAnswer> selectedAnswers;
	String freeTextAnswer;
	boolean isCorrect;
	
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public List<ChoiceAnswer> getSelectedAnswers() {
		return selectedAnswers;
	}
	public void setSelectedAnswers(List<ChoiceAnswer> selectedAnswers) {
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
	

}
