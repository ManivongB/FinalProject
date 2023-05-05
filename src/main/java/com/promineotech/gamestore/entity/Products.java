package com.promineotech.gamestore.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Products {
  
  private int productId;
  private BigDecimal price;
  private String productName;
  private ProductConsole console;
  private ProductGame game;
  
}
