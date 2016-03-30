package com.nab.skilltest.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Path;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.nab.skilltest.dao.ExamDAOImpl;
import com.nab.skilltest.dao.QuestionDAOImpl;
import com.nab.skilltest.dao.SimpleMongoDaoImpl;
import com.nab.skilltest.helper.ExamHelper;
import com.nab.skilltest.model.Candidate;
import com.nab.skilltest.model.CandidateAnswer;
import com.nab.skilltest.model.ComplexityLevel;
import com.nab.skilltest.model.Exam;
import com.nab.skilltest.model.QuestionType;
import com.nab.skilltest.model.Skill;
import com.nab.skilltest.model.Tag;
import com.nab.skilltest.ui.model.AnswerResponse;
import com.nab.skilltest.ui.model.Question;
@Path("/examservice")
public class ExamServiceImpl implements ExamService {
	
	public static ExamDAOImpl examDAO;
	public static QuestionDAOImpl questionDAO;
	public static ExamHelper examHelper;
	static{
		ApplicationContext ctx = new GenericXmlApplicationContext("applicationcontext.xml");
		examDAO = (ExamDAOImpl)ctx.getBean("examDAO");	
		questionDAO = (QuestionDAOImpl)ctx.getBean("questionDAO");	
		examHelper = (ExamHelper)ctx.getBean("examHelper");	
	}

	@Override
	public String welcome(String name) {
		String response="Welcome "+name+"!!! Please fasten your seatbelt. We are ready to take off!!!";
		com.nab.skilltest.model.Question model = new com.nab.skilltest.model.Question();
		model.setId(6);
		model.setDescription("What does AWT stands for?");
		List<String> l= new ArrayList<String>();
		l.add("All Window Tools");
		l.add("All Writing Tools");
		l.add("Abstract Window Toolkit");
		l.add("Abstract Writing Toolkit");
		model.setAnswerOptions(l);
		model.setcLevel(ComplexityLevel.EASY);
		l= new ArrayList<String>();
		l.add("Abstract Window Toolkit");
		model.setCorrectAnswers(l);
		model.setqType(QuestionType.SINGLE_CHOICE);
		model.setSkill(Skill.CORE_JAVA);
		questionDAO.save(model);
		
		model.setId(7);
		l= new ArrayList<String>();
		model.setDescription("Which of these is used to perform all input & output operations in Java?");
		l.add("streams");
		l.add("Variables");
		l.add("classes");
		l.add("Methods");
		model.setAnswerOptions(l);
		model.setcLevel(ComplexityLevel.MEDIUM);
		l= new ArrayList<String>();
		l.add("streams");
		model.setCorrectAnswers(l);
		model.setqType(QuestionType.SINGLE_CHOICE);
		model.setSkill(Skill.CORE_JAVA);
		questionDAO.save(model);
		
		model.setId(8);
		model.setDescription("Write a prog to print strings permutations in java?");
		model.setcLevel(ComplexityLevel.HARD);
		model.setqType(QuestionType.FREE_TEXT);
		model.setSkill(Skill.CORE_JAVA);
		questionDAO.save(model);
		
		model.setId(9);
		model.setDescription("Which of these class is used to read from byte array?");
		l= new ArrayList<String>();
		l.add("InputStream.");
		l.add("BufferedInputStream");
		l.add("ArrayInputStream");
		l.add("ByteArrayInputStream");
		model.setAnswerOptions(l);
		model.setcLevel(ComplexityLevel.MEDIUM);
		l= new ArrayList<String>();
		l.add("ByteArrayInputStream");
		model.setCorrectAnswers(l);
		model.setqType(QuestionType.SINGLE_CHOICE);
		model.setSkill(Skill.CORE_JAVA);
		questionDAO.save(model);
		
		model.setId(10);
		model.setDescription("Which of these is a type of stream in Java?");
		l= new ArrayList<String>();
		l.add("Integer stream");
		l.add("Short stream");
		l.add("Byte stream");
		l.add("Long stream");
		model.setAnswerOptions(l);
		model.setcLevel(ComplexityLevel.MEDIUM);
		l= new ArrayList<String>();
		l.add("Byte stream");
		model.setCorrectAnswers(l);
		model.setqType(QuestionType.SINGLE_CHOICE);
		model.setSkill(Skill.CORE_JAVA);
		questionDAO.save(model);
		
		
		//model.setTags(Tag.);
		return response;
	}
	
	@Override
	public Question createExam(String templateId,Candidate candidate) {
		
		Question ret;
		Exam ex= new Exam();
		ex.setCandidate(candidate);
		ex.setId(examDAO.getTotalExam()+1);
		List<com.nab.skilltest.model.Question> listQuestions =examHelper.retrieveQuestionsBasedOnTemplate(templateId);
		examHelper.populateExamWithQuestions(ex,listQuestions);
		examDAO.saveExam(ex);
		List<CandidateAnswer> list =ex.getMyAnswers();
		Collections.sort(list);
		com.nab.skilltest.model.Question q=questionDAO.retrieveQuestion(list.get(0).getQuestionID());
		ret=examHelper.transform(q);
		ret.setPreviousQuestion(-1);
		ret.setNextQuestion(list.get(1).getQuestionID());
		ret.setTotalCount(listQuestions.size());
		ret.setAnswerCount(0);
		ret.setExamID(ex.getId());
		ret.setQuestionSequenceNumber(0);
		return ret;
	}

	@Override
	public Question submitAnswer(AnswerResponse answer) {
		Exam exam =examDAO.retrieveExam(answer.getExamID());
		examDAO.updateExam(exam,answer);
		Question ret = examHelper.transform(questionDAO.retrieveQuestion(answer.getNextQuestion()));
		int nextQuestion = examHelper.getNextQuestion(exam.getMyAnswers(),ret.getQuestionId(),answer.isNext());
		if(answer.isNext()){
			ret.setPreviousQuestion(answer.getQuestionId());
			ret.setNextQuestion(nextQuestion);
		}else{
			ret.setPreviousQuestion(nextQuestion);
			ret.setNextQuestion(answer.getQuestionId());
		}
		ret.setTotalCount(exam.getMyAnswers().size());
		ret.setAnswerCount(examHelper.getAnswerCount(exam.getMyAnswers()));
		ret.setExamID(answer.getExamID());
		ret.setSelectedAnswers(examHelper.getSelectedAnswer(exam,ret.getQuestionId()));
		ret.setQuestionSequenceNumber(examHelper.getSequenceNumber(exam,ret.getQuestionId()));
		return ret;
	}

	@Override
	public String finish(AnswerResponse answer) {
		Exam exam =examDAO.retrieveExam(answer.getExamID());
		examDAO.updateExam(exam,answer);
		return "Thanks for taking the exam!";
	}

}
