package com.cts.rest.service;

import java.util.Calendar;

import javax.ws.rs.Path;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.cts.skilltest.dao.SimpleMongoDaoImpl;
import com.cts.skilltest.model.User;
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
		//Dummy service only for understanding only 
		if(usr.getId()==0){
			usr.setId(1234);
		}
		ApplicationContext ctx = new GenericXmlApplicationContext("applicationcontext.xml");
		SimpleMongoDaoImpl mydao = (SimpleMongoDaoImpl)ctx.getBean("myMongoDAO");	
		mydao.saveUser(usr);
		User s=mydao.getUser(usr.getId());
		System.out.println(" hiya : nabin: mongo "+mydao);
		return usr;
	}

	public String welcome(String name) {
		String response="Welcome "+name+"!!! Please fasten your seatbelt. We are ready to take off!!!";
		return response;
	}

}
