package ru.alex.Telegramshop.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.telegram.telegrambots.meta.api.objects.payments.OrderInfo;


import java.time.Instant;

@Data
@Document
@Builder
@AllArgsConstructor
public class Purchase {
  @Id
  private String id;

  private String chatId;

  private String currency;

  private Shaurma shaurma;

  private Instant purchaseDate;

  private OrderInfo orderInfo;


}
