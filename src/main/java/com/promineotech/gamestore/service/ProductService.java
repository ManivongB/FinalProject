package com.promineotech.gamestore.service;

import java.util.List;
import com.promineotech.gamestore.entity.Products;

public interface ProductService {

  List<Products> fetchProducts();

}
