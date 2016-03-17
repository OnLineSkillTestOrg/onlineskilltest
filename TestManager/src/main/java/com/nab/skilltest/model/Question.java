package com.nab.skilltest.model;

import java.util.List;

public class Question {
	
	int id;
	String description;
	List<ChoiceAnswer> answerOptions;
	List<ChoiceAnswer> correctAnswers;
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
	public List<ChoiceAnswer> getAnswerOptions() {
		return answerOptions;
	}
	public void setAnswerOptions(List<ChoiceAnswer> answerOptions) {
		this.answerOptions = answerOptions;
	}
	public List<ChoiceAnswer> getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(List<ChoiceAnswer> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	public QuestionType getqType() {
		return qType;
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
