package com.nab.skilltest.model;

import java.util.List;

public class CandidateAnswer {
	
	Question question;
	List<ChoiceAnswer> selectedAnswers;
	String freeTextAnswer;
	boolean isCorrect;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
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
