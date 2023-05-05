package com.promineotech.gamestore.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductOrders {

  private int orderId;
  
  private int productId;
}
