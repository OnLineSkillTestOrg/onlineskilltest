package com.nab.skilltest.ui.model;

import java.util.List;

import com.nab.skilltest.model.QuestionType;

public class Question {
	
	int totalCount;
	int answerCount;
	int examID;
	String questionText;
	int questionId;
	String questionSequenceNumber;
	QuestionType questionType;
	List<String> answers;
	int previousQuestion;
	int nextQuestion;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionSequenceNumber() {
		return questionSequenceNumber;
	}
	public void setQuestionSequenceNumber(String questionSequenceNumber) {
		this.questionSequenceNumber = questionSequenceNumber;
	}
	public QuestionType getQuestionType() {
		return questionType;
	}
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	public int getPreviousQuestion() {
		return previousQuestion;
	}
	public void setPreviousQuestion(int previousQuestion) {
		this.previousQuestion = previousQuestion;
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

}
