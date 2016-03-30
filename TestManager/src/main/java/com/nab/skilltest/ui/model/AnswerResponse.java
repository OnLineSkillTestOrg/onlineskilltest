package com.nab.skilltest.ui.model;

import java.util.List;

public class AnswerResponse {
	
	int questionId;
	int examID;
	 boolean isNext =true;
	List<String> selectedAnswers;
	int nextQuestion;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public List<String> getSelectedAnswers() {
		return selectedAnswers;
	}
	public void setSelectedAnswers(List<String> selectedAnswers) {
		this.selectedAnswers = selectedAnswers;
	}
	public int getNextQuestion() {
		return nextQuestion;
	}
	public void setNextQuestion(int nextQuestion) {
		this.nextQuestion = nextQuestion;
	}
	public int getExamID() {
		return examID;
	}
	public void setExamID(int examID) {
		this.examID = examID;
	}
	public boolean isNext() {
		return isNext;
	}
	public void setNext(boolean isNext) {
		this.isNext = isNext;
	}
}
