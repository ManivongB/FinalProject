package com.promineotech.gamestore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.gamestore.entity.ProductOrders;
import com.promineotech.gamestore.service.ProductOrdersService;

@RestController
public class DefaultProductOrdersController implements ProductOrdersController{

  @Autowired
  private ProductOrdersService productOrdersService;
  
  @Override
  public List<ProductOrders> fetchProductOrders() {
    
    return productOrdersService.fetchProductOrders();
  }

}
