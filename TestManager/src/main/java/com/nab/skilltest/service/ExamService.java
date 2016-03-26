package com.nab.skilltest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nab.skilltest.model.Candidate;
import com.nab.skilltest.ui.model.AnswerResponse;
import com.nab.skilltest.ui.model.Question;


public interface ExamService {
	
	
	
	@GET
	@Path("/user/welcome/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String welcome(@PathParam("name") String name);
	
	
	@POST
	@Path("/exam/{templateId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Question createExam(@PathParam("templateId") String templateId,Candidate candidate);
	
//	/exaemplateId=1
	
	@POST
	@Path("/answer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Question submitAnswer(AnswerResponse answer);
	// /answer
	
	@POST
	@Path("/finish")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String finish(AnswerResponse answer);

}
