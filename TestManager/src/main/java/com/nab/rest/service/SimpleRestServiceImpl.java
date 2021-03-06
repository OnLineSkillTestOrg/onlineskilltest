package com.nab.rest.service;

import java.util.Calendar;

import javax.ws.rs.Path;










import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.nab.skilltest.dao.SimpleMongoDaoImpl;
import com.nab.skilltest.model.User;
@Path("/simpleservice")
public class SimpleRestServiceImpl implements SimpleRestService {
	@Autowired
	SimpleMongoDaoImpl mydao;
	public SimpleMongoDaoImpl getMydao() {
		return mydao;
	}

	public void setMydao(SimpleMongoDaoImpl mydao) {
		this.mydao = mydao;
	}
	
	public User createUser(User usr) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("applicationcontext.xml");
		SimpleMongoDaoImpl mydao = (SimpleMongoDaoImpl)ctx.getBean("myMongoDAO");	
		mydao.saveUser(usr);
		User s=mydao.getUser(usr.getId());
		System.out.println(" hiya : nabin: mongo "+mydao);
		return s;
	}

	public String welcome(String name) {
		String response="Welcome "+name+"!!! Please fasten your seatbelt. We are ready to take off!!!";
		return response;
	}

}
