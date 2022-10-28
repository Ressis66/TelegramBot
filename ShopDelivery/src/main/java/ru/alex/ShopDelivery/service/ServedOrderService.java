package ru.alex.ShopDelivery.service;

import org.springframework.stereotype.Component;
import ru.alex.ShopDelivery.client.JSONPlaceHolderClient;
import ru.alex.ShopDelivery.domain.ServedOrder;
import ru.alex.ShopDelivery.model.Order;

import java.util.ArrayList;
import java.util.List;
@Component
public class ServedOrderService {

  private JSONPlaceHolderClient client;

  public ServedOrderService(JSONPlaceHolderClient client) {
    this.client = client;
  }
  public List<ServedOrder>getAllServedOrders(){
    List<ServedOrder> servedOrders= new ArrayList<>();
    for(Order order: client.getOrders())
      servedOrders.add(createServedOrder(order));
    return servedOrders;
  }

  public ServedOrder createServedOrder(Order order){

    ServedOrder servedOrder = new ServedOrder();
    servedOrder.setId(order.getId());
    servedOrder.setShaurma(order.getShaurma().getName());
    servedOrder.setAddress(order.getOrderInfo().getShippingAddress().toString());
    servedOrder.setDate(order.getPurchaseDate().toString());
 return servedOrder;
  }

}
