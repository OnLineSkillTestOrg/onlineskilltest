package com.cts.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.skilltest.dao.SimpleMongoDao;
import com.cts.skilltest.dao.SimpleMongoDaoImpl;
import com.cts.skilltest.model.User;

@RestController("/ssrestservice")
public class SimpleSpringRestService {
	@Autowired
	SimpleMongoDao mydao;
	public SimpleMongoDao getMydao() {
		return mydao;
	}

	public void setMydao(SimpleMongoDao mydao) {
		this.mydao = mydao;
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		
		return "Welcome 2 the world of spring rest!!";

	}

	@RequestMapping(value = "/user/{id:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
		User user= this.mydao.getUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

}
