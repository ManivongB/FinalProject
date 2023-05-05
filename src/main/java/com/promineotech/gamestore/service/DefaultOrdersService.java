package com.promineotech.gamestore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.gamestore.dao.OrdersDao;
import com.promineotech.gamestore.entity.Orders;

@Service
public class DefaultOrdersService implements OrdersService{

  @Autowired
  private OrdersDao ordersDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Orders> fetchOrders() {
    List<Orders> orders = ordersDao.fetchOrders();
    return orders;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Orders> fetchOrderByCustomerId(String customerId) {
    List<Orders> orders = ordersDao.fetchOrdersByCustomerId(customerId);
    return orders;
  }

  @Override
  public Orders createOrder(int customerId) {
    
    return ordersDao.createOrder(customerId);
  }

  @Override
  public Orders updateOrder(int customerId, int orderId) {
    
    return ordersDao.updateOrder(customerId, orderId);
  }

  @Override
  public void deleteOrder(int orderId) {
    ordersDao.deleteOrder(orderId);
    
  }
  

}
