package ru.alex.ShopDelivery.model;

import java.math.BigDecimal;

public class Shaurma {

  public Shaurma(String id, String name, BigDecimal price, String description, String photo) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.photo = photo;
  }

  private String id;

  private String name;

  private BigDecimal price;

  private String description;

  private String photo;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }
}
