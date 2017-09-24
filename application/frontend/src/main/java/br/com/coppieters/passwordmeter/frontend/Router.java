package br.com.coppieters.passwordmeter.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Router {
	
	@RequestMapping("/")
	public String routes() {
		return "index";
	}
	
}
