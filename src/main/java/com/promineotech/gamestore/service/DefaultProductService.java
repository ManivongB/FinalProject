package com.promineotech.gamestore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.gamestore.dao.ProductDao;
import com.promineotech.gamestore.entity.Products;

@Service
public class DefaultProductService implements ProductService {
  
  @Autowired
  private ProductDao productDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Products> fetchProducts() {
    List<Products> products = productDao.fetchProducts();
    
    return products;
  }

}
