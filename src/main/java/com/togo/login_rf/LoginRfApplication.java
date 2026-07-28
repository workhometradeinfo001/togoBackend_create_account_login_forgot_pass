package com.togo.login_rf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.togo.login_rf.repo")
public class LoginRfApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginRfApplication.class, args);
	}

}
