package com.promineotech.gamestore.service;

import java.util.List;
import com.promineotech.gamestore.entity.Orders;

public interface OrdersService {
 

   
    List<Orders> fetchOrders();

   
    List<Orders> fetchOrderByCustomerId(String customerId);

    
    Orders createOrder(int customerId);

    
    Orders updateOrder(int customerId, int orderId);

    
    void deleteOrder(int orderId);
}
