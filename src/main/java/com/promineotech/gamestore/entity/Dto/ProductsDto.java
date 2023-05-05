package com.promineotech.gamestore.entity.Dto;

import java.math.BigDecimal;
import com.promineotech.gamestore.entity.ProductConsole;
import com.promineotech.gamestore.entity.ProductGame;

public class ProductsDto {

  
  private int productId;
  private BigDecimal price;
  private String productName;
  private ProductConsole console;
  private ProductGame game;
  
  public int getProductId() {
    return productId;
  }
  
  public BigDecimal getPrice(){
    return price;
  }
  
  public String getProductName() {
    return productName;
 
  }
  
  public ProductConsole getConsole() {
    return console;
    
  }
  
  public ProductGame getGame() {
    return game;
  }
}
