package com.SrpingBoot.Shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;
@SpringBootApplication
public class ShoppingApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().load();
		String db_Url = dotenv.get("DB_URL");
		String db_Username = dotenv.get("DB_USERNAME");
		String db_Password = dotenv.get("DB_PASSWORD");

		// 환경 변수를 Spring Boot 애플리케이션에 적용
		System.setProperty("spring.datasource.url", db_Url);
		System.setProperty("spring.datasource.username", db_Username);
		System.setProperty("spring.datasource.password", db_Password);

		SpringApplication.run(ShoppingApplication.class, args);
	}

}
