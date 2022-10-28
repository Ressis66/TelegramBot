package ru.alex.ShopDelivery.hystrix;

import org.springframework.stereotype.Component;
import ru.alex.ShopDelivery.client.JSONPlaceHolderClient;
import ru.alex.ShopDelivery.model.Order;

import java.util.Collections;
import java.util.List;

@Component
public class JSONPlaceHolderFallback implements JSONPlaceHolderClient {

  @Override
  public List<Order> getOrders() {
    return Collections.emptyList();
  }

  @Override
  public Order getOrderById(String orderId) {
    return null;
  }
}
