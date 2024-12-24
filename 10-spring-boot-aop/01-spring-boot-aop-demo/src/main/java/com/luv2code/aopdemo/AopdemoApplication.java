package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.abstracts.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDao){

		return runner -> {

			demoTheBeforeAdvice(theAccountDao);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDao) {

		theAccountDao.addAccount();

	}

}
