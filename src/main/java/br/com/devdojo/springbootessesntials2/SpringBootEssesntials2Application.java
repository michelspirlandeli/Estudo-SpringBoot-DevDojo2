package br.com.devdojo.springbootessesntials2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.devdojo.springbootessesntials2")
public class SpringBootEssesntials2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEssesntials2Application.class, args);
	}

}
