package ru.alex.ShopDelivery.model;

import org.telegram.telegrambots.meta.api.objects.payments.OrderInfo;

import java.time.Instant;

public class Order {

  private String id;

  private String chatId;

  private String currency;

  private Shaurma shaurma;

  private Instant purchaseDate;

  private OrderInfo orderInfo;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getChatId() {
    return chatId;
  }

  public void setChatId(String chatId) {
    this.chatId = chatId;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Shaurma getShaurma() {
    return shaurma;
  }

  public void setShaurma(Shaurma shaurma) {
    this.shaurma = shaurma;
  }

  public Instant getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(Instant purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public OrderInfo getOrderInfo() {
    return orderInfo;
  }

  public void setOrderInfo(OrderInfo orderInfo) {
    this.orderInfo = orderInfo;
  }
}
