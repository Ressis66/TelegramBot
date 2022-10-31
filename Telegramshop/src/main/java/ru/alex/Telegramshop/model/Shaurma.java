package ru.alex.Telegramshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shaurma {
  @Id
  private String id;

  private String name;

  private BigDecimal price;

  private String description;

  private String photo;
}
