package com.promineotech.gamestore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.gamestore.dao.ProductOrdersDao;
import com.promineotech.gamestore.entity.ProductOrders;

@Service
public class DefaultProductOrdersService implements ProductOrdersService {
  
  @Autowired
  private ProductOrdersDao productOrdersDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<ProductOrders> fetchProductOrders() {
    List<ProductOrders> productOrders = productOrdersDao.fetchProductOrders();
    return productOrders;
  }

}
