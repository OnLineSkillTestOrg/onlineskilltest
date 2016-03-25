package com.nab.skilltest.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nab.skilltest.dao.QuestionDAO;
import com.nab.skilltest.model.CandidateAnswer;
import com.nab.skilltest.model.Exam;
import com.nab.skilltest.model.Question;

@Component("examHelper")
public class ExamHelper {
	
	@Autowired
	QuestionDAO questionDAO;
	
	public QuestionDAO getQuestionDAO() {
		return questionDAO;
	}

	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}


	public List<Question> retrieveQuestionsBasedOnTemplate(String templateID){
		
		int size=questionDAO.getTotalQuestion();
		List<Question> retLists=new ArrayList<Question>();
		List<Integer> takenQIDs= new ArrayList<Integer>();
		while(true){
			Integer qID= new Integer(""+Math.round(Math.random()*size));
			if(!takenQIDs.contains(qID)){
				takenQIDs.add(qID);
			}
			if(takenQIDs.size()==(size/2)){
				break;
			}
		}
		
		for(Integer qIDs:takenQIDs){
			retLists.add(questionDAO.retrieveQuestion(qIDs));
		}
		return retLists;
	}
	
	public com.nab.skilltest.ui.model.Question transform(Question question){
		
		com.nab.skilltest.ui.model.Question  uiquestion = new com.nab.skilltest.ui.model.Question();
		uiquestion.setQuestionText(question.getDescription());
		uiquestion.setAnswers(question.getAnswerOptions());
		uiquestion.setQuestionType(question.getqType());
		uiquestion.setQuestionId(question.getId());
		return uiquestion;
	}

	public void populateExamWithQuestions(Exam ex,
			List<com.nab.skilltest.model.Question> listQuestions) {
		
		List<CandidateAnswer> list = new ArrayList<CandidateAnswer>();
		for(Question q:listQuestions){
			if(q!=null){
				CandidateAnswer ca = new CandidateAnswer();
				ca.setQuestionID(q.getId());
				ca.setSelectedAnswers(null);
				list.add(ca);
			}
		}
		
		ex.setMyAnswers(list);
		
	}

	public int getNextQuestion(List<CandidateAnswer> myAnswers, int questionId) {
		int nextQuestionID=-1;
		for(int i=0;i<myAnswers.size();i++){
			if(myAnswers.get(i).getQuestionID()==questionId){
				if((i+1)<myAnswers.size()){
					nextQuestionID= myAnswers.get(i+1).getQuestionID();
				}
			}
		}
		
		return nextQuestionID;
	}

	public int getAnswerCount(List<CandidateAnswer> myAnswers) {
		int count=0;
		for(CandidateAnswer canAn: myAnswers){
			if(canAn.getSelectedAnswers()!=null && canAn.getSelectedAnswers().size()>0){
				count++;
			}
			else if(canAn.getFreeTextAnswer()!=null && canAn.getFreeTextAnswer().trim().length()>0){
				count++;
			}
		}
		return count;
	}
	
}
