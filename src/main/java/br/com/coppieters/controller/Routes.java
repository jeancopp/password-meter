package br.com.coppieters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Classe responsável por realizar o roteamento das páginas da aplicação
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
@Controller
public class Routes {

	@RequestMapping("/")
	public String getPage(){
		return "index";
	}
	
}
