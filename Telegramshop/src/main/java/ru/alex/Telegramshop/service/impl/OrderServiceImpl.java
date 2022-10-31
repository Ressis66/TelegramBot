package ru.alex.Telegramshop.service.impl;



import org.springframework.stereotype.Component;

import org.telegram.telegrambots.meta.api.objects.payments.SuccessfulPayment;
import ru.alex.Telegramshop.model.Purchase;
import ru.alex.Telegramshop.repository.PurchaseRepository;
import ru.alex.Telegramshop.service.OrderService;

import java.time.Instant;
import java.util.UUID;


@Component
public class OrderServiceImpl implements OrderService {

  private PurchaseRepository repository;

  private ShaurmaServiceImpl shaurmaService;

  public OrderServiceImpl(PurchaseRepository repository, ShaurmaServiceImpl shaurmaService) {
    this.repository = repository;
    this.shaurmaService = shaurmaService;
  }

  public void createPurchase(SuccessfulPayment payment, String chatId) {
    String phoneId = payment.getInvoicePayload();
    shaurmaService.getShaurmas().stream()
        .filter(phone -> phone.getId().equals(phoneId))
        .findAny()
        .map(phone -> Purchase.builder()
            .id(UUID.randomUUID().toString())
            .currency(payment.getCurrency())
            .chatId(chatId)
            .orderInfo(payment.getOrderInfo())
            .shaurma(phone)
            .purchaseDate(Instant.now())
            .build())
        .ifPresent(purchase -> {
          repository.save(purchase);
        });
  }


  }


