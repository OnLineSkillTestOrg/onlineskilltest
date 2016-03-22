package com.nab.skilltest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nab.skilltest.model.User;
import com.nab.skilltest.model.json.AnswerResponse;
import com.nab.skilltest.model.json.Question;


@Service
public interface ExamService {
	
	
	@POST
	@Path("/exam")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	ResponseEntity<Question> createExam(@PathParam("templateId") String templateId);
	
	@POST
	@Path("/answer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	ResponseEntity<Question> submitAnswer(AnswerResponse answer);

}
