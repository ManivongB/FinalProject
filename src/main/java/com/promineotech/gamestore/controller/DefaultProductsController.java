package com.promineotech.gamestore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.gamestore.entity.Products;
import com.promineotech.gamestore.service.ProductService;


@RestController
public class DefaultProductsController implements ProductsController{

  @Autowired
  private ProductService productService;
  
  @Override
  public List<Products> fetchProducts() {
    
    return productService.fetchProducts();
  }

}
