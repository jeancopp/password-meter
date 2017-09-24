package br.com.coppieters.passwordmeter.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.coppieters.passwordmeter.application.ScoreApplication;
import br.com.coppieters.passwordmeter.commons.utils.ResponseDtoBuilder;

@RestController
@RequestMapping("/password")
public class PasswordController {
	private final Logger LOG = Logger.getLogger(PasswordController.class);

	@Autowired
	ResponseDtoBuilder<Map<String,String>> responseDtoBuilder; 
	
	@Autowired
	ScoreApplication<Map<String,String>> application;

	@RequestMapping(method = RequestMethod.GET, value = "/score",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getScore(@RequestParam(name = "pass", required = true) String pass){
		LOG.trace("Inicio - Password: " + pass);
		try{
			return new ResponseEntity<>(application.calculateScore(pass,responseDtoBuilder), HttpStatus.OK);
		}catch(Exception e){
			LOG.trace("Erro inexperado",e);
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			LOG.trace("Fim");
		}
		
	}
}
