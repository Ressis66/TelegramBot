package ru.alex.Telegramshop;
import org.telegram.telegrambots.meta.api.objects.payments.OrderInfo;
import org.telegram.telegrambots.meta.api.objects.payments.ShippingAddress;
import ru.alex.Telegramshop.model.Purchase;
import ru.alex.Telegramshop.model.Shaurma;
import ru.alex.Telegramshop.repository.PurchaseRepository;
import ru.alex.Telegramshop.repository.ShaurmaRepository;
import ru.alex.Telegramshop.service.ShaurmaService;

import java.math.BigDecimal;
import java.time.Instant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories
@SpringBootApplication
public class TelegramshopApplication implements CommandLineRunner {


	@Autowired
	private ShaurmaRepository shaurmaRepository;

	@Autowired
	private PurchaseRepository purchaseRepository;


		public static void main(String[] args) {

			SpringApplication.run(TelegramshopApplication.class, args);

		}
	@Override
	public void run(String... args) throws Exception {
		Shaurma shaurma = new Shaurma("1", "Sahurema",
				BigDecimal.valueOf(10), "Super","https://static.1000.menu/img/content-v2/05/d8/21554/klassicheskaya-shaurma_1589963797_12_max.jpg");
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setShippingAddress(new ShippingAddress("453083", "Russsia","Chaelyzbinsk", "Novikova", "10", "12"));
		shaurmaRepository.save(shaurma);

		purchaseRepository.save(new Purchase("12", "1243234", "RUB", shaurma, Instant.now(),orderInfo));
	}

	}


