package com.promineotech.gamestore.dao;

import java.util.List;
import com.promineotech.gamestore.entity.ProductOrders;

public interface ProductOrdersDao {
  
  List<ProductOrders> fetchProductOrders();

}
