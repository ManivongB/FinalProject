package com.promineotech.gamestore.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.gamestore.entity.Orders;
import com.promineotech.gamestore.entity.Dto.OrdersDto;
import com.promineotech.gamestore.service.OrdersService;

@RestController
public class DefaultOrdersController implements OrdersController{

  @Autowired
  private OrdersService orderService;
  
 
  @Override
  public List<Orders> fetchOrders() {
    return orderService.fetchOrders();
  }

  
  @Override
  public List<Orders> fetchOrderByCustomerId(String customerId) {
    return orderService.fetchOrderByCustomerId(customerId);
  }


  @Override
  public Orders createOrder(@Valid OrdersDto orderDto) {
    return orderService.createOrder(orderDto.
        getCustomerId());
  }


  @Override
  public Orders updateOrder(@Valid OrdersDto orderDto) {
    return orderService.updateOrder(orderDto.
        getCustomerId(), orderDto.getOrderId());
  }


  @Override
  public void deleteOrder(@Valid OrdersDto orderDto) {
    orderService.deleteOrder(orderDto.getOrderId());
    
  }
}
