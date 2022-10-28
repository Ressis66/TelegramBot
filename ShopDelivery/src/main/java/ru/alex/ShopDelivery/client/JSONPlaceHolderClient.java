package ru.alex.ShopDelivery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.alex.ShopDelivery.hystrix.JSONPlaceHolderFallback;
import ru.alex.ShopDelivery.model.Order;

import java.util.List;

@FeignClient(value = "jplaceholder",
    url = "http://localhost:8080/",
    fallback = JSONPlaceHolderFallback.class)
public interface JSONPlaceHolderClient {

  @RequestMapping(method = RequestMethod.GET, value = "/orders")
  List<Order> getOrders();


  @RequestMapping(method = RequestMethod.GET, value = "/orders/{orderId}", produces = "application/json")
  Order getOrderById(@PathVariable("orderId") String orderId);
}
