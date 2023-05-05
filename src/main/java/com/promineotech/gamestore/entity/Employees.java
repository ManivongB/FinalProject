package com.promineotech.gamestore.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employees {

  private int employeeId;
  private String employeeName;
  
}
