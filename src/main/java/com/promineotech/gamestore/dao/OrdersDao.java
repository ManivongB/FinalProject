package com.promineotech.gamestore.dao;

import java.util.List;
import com.promineotech.gamestore.entity.Orders;

public interface OrdersDao {

  List<Orders> fetchOrders();

  List<Orders> fetchOrdersByCustomerId(String customerId);

  Orders createOrder(int customerId);

  Orders updateOrder(int customerId, int orderId);

  void deleteOrder(int orderId);

}
