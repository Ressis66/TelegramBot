package ru.alex.Telegramshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.Telegramshop.model.Purchase;
import ru.alex.Telegramshop.repository.PurchaseRepository;

import java.util.List;

@RestController
public class RestApiController {

  PurchaseRepository repository;

  public RestApiController(PurchaseRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/orders")
  public List<Purchase> getOrders() {
    return repository.findAll();
  }


}
