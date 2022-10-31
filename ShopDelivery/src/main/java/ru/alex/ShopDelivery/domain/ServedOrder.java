package ru.alex.ShopDelivery.domain;

import java.util.Date;

public class ServedOrder {

  private String id;
  private String shaurma;
  private String address;
  private String date;

  public ServedOrder(String id, String shaurma, String address, String date) {
    this.id = id;
    this.shaurma = shaurma;
    this.address=address;
    this.date=date;
  }

  public ServedOrder() {
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getShaurma() {
    return shaurma;
  }

  public void setShaurma(String shaurma) {
    this.shaurma = shaurma;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


}
