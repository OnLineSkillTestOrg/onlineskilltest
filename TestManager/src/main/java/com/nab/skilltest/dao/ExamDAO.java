package com.nab.skilltest.dao;

import com.nab.skilltest.model.Exam;
import com.nab.skilltest.ui.model.AnswerResponse;

public interface ExamDAO {
	
	public void saveExam(Exam exam);
	
	public Exam retrieveExam(int examID);
	
	public int getTotalExam();
	
	public void updateExam(Exam exam,AnswerResponse answer);

}
