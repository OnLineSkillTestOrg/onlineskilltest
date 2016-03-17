package com.nab.skilltest.model;

import java.util.List;

public class Candidate {
	
	long id;
	String name;
	//TODO other details
	List<Exam> exams;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Exam> getExams() {
		return exams;
	}
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	

}
