package com.nab.skilltest.model;

import java.util.List;

public class QuestionTemplate {
	
	int id;
	QuestionType qType;
	Skill skill;
	ComplexityLevel cLevel;
	List<Tag> tags;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public QuestionType getqType() {
		return qType;
	}
	public void setqType(QuestionType qType) {
		this.qType = qType;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public ComplexityLevel getcLevel() {
		return cLevel;
	}
	public void setcLevel(ComplexityLevel cLevel) {
		this.cLevel = cLevel;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
}
