package ru.alex.Telegramshop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories
@SpringBootApplication
public class TelegramshopApplication {



		public static void main(String[] args) {

			SpringApplication.run(TelegramshopApplication.class, args);

		}


	}


