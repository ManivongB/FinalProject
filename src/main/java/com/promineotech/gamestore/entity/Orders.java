package com.promineotech.gamestore.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orders {

  private int orderId;
  private int customerId;
  private int productId;
  private int employeeId;
}
