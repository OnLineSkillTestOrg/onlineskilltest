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


@Service
public interface ExamService {
	
	
	@POST
	@Path("/exam")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	ResponseEntity<User> createExam(@PathParam("templateId") String templateId);

}
