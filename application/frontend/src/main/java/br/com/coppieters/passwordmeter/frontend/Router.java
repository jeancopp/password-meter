package br.com.coppieters.passwordmeter.frontend;

import java.net.URI;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class Router {
	
	@Value("${backend.uri}")
	private String backenduri;

	
	@RequestMapping("/")
	public String routes() {
		return "index";
	}
	
//	@RequestMapping("/api/**")
//	public ResponseEntity<?> callBackEnd(@RequestBody(required=false) Map<?,?> body, 
//			HttpServletRequest req, HttpServletResponse resp) {
//		try {
//			HttpMethod method = HttpMethod.resolve( req.getMethod() );
//			boolean hasOutBody = !"GET".equalsIgnoreCase(req.getMethod());
//            final URI url = new URI(req.getRequestURI().replaceAll("/api", backenduri) 
//                    + (req.getQueryString() != null ? "?" + req.getQueryString() : ""));
//            
//			return hasOutBody ? rest.exchange(url, method, new HttpEntity<>(body), Map.class)
//					: rest.getForEntity(url, Map.class);
//		}catch(Exception e) {
//			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
//		}
//	}
}
