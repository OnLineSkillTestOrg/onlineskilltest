package com.nab.skilltest.model;

import java.util.List;

public class Question {
	
	int id;
	String description;
	List<String> answerOptions;
	List<String> correctAnswers;
	QuestionType qType;
	ComplexityLevel cLevel;
	Skill skill;
	List<Tag> tags;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public QuestionType getqType() {
		return qType;
	}
	public List<String> getAnswerOptions() {
		return answerOptions;
	}
	public void setAnswerOptions(List<String> answerOptions) {
		this.answerOptions = answerOptions;
	}
	public List<String> getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(List<String> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	public void setqType(QuestionType qType) {
		this.qType = qType;
	}
	public ComplexityLevel getcLevel() {
		return cLevel;
	}
	public void setcLevel(ComplexityLevel cLevel) {
		this.cLevel = cLevel;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	

}
