package com.promineotech.gamestore.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
  
  private int customerId;
  private String firstName;
  private String lastName;
  private String phoneNumber;

}
