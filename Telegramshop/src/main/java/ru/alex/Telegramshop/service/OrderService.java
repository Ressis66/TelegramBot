package ru.alex.Telegramshop.service;



import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.telegram.telegrambots.meta.api.objects.payments.SuccessfulPayment;
import ru.alex.Telegramshop.model.Purchase;
import ru.alex.Telegramshop.repository.PurchaseRepository;

import java.io.FileOutputStream;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class OrderService {

  @Autowired
  private PurchaseRepository repository;

  @Autowired
  private ShaurmaService shaurmaService;

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


