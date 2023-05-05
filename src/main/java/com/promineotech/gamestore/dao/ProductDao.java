package com.promineotech.gamestore.dao;

import java.util.List;
import com.promineotech.gamestore.entity.Products;

public interface ProductDao {

  List<Products> fetchProducts();
}
