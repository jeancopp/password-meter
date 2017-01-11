package br.com.coppieters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Routes {

	@RequestMapping("/")
	public String getPage(){
		return "index";
	}
	
}
