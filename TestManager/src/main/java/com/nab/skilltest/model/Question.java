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
	

}
