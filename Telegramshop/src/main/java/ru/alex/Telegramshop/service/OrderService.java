package ru.alex.Telegramshop.service;

import org.telegram.telegrambots.meta.api.objects.payments.SuccessfulPayment;

public interface OrderService {

  void createPurchase(SuccessfulPayment payment, String chatId);
}
