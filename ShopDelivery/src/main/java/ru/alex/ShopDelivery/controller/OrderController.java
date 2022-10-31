package ru.alex.ShopDelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.ShopDelivery.client.JSONPlaceHolderClient;
import ru.alex.ShopDelivery.domain.ServedOrder;
import ru.alex.ShopDelivery.model.Order;
import ru.alex.ShopDelivery.service.ServedOrderService;

import java.util.Arrays;
import java.util.List;


@RestController
public class OrderController {

  private ServedOrderService service;

  public OrderController(ServedOrderService service) {
   this.service=service;

  }

  @GetMapping("/list")
  public List<ServedOrder> listServedOrders() {
    List<ServedOrder> payments = service.getAllServedOrders();
    return payments;
  }


}
