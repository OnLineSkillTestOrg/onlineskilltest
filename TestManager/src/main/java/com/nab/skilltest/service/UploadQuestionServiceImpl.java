package com.nab.skilltest.service;

import java.io.File;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.nab.skilltest.dao.QuestionDAOImpl;
import com.nab.skilltest.model.Question;
import com.nab.skilltest.question.util.QuestionHelper;

//@Repository("uploadQuestionService")
public class UploadQuestionServiceImpl implements UploadQuestionService {

	private static final ApplicationContext  CONTEXT = new ClassPathXmlApplicationContext("/applicationcontext.xml");
	private QuestionDAOImpl questionDAO;
	
	@Override
	public void uploadQuestion(String fileLocation) {
		questionDAO = (QuestionDAOImpl)CONTEXT.getBean("questionDAO");
		//temporarily reading file from disk location, until UI for upload is developed.
		File file = new File("C://dev//ExamTemplate.xlsx");
		List<Question> ql = new QuestionHelper().readExcel(file);
		try {
			for(Question q : ql) {
				questionDAO.save(q);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Question getQuestionById(String questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
