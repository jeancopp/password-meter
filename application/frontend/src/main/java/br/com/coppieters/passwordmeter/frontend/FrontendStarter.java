package br.com.coppieters.passwordmeter.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "br.com.coppieters.passwordmeter.frontend")
public class FrontendStarter {
	
	public static void main(String[] args) {
		SpringApplication.run(FrontendStarter.class, args);
	}
	
}
