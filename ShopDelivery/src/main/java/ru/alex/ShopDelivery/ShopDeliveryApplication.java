package ru.alex.ShopDelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients
public class ShopDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopDeliveryApplication.class, args);
	}



}
