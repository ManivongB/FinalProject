package com.promineotech.gamestore.service;

import java.util.List;

import com.promineotech.gamestore.entity.Employees;

public interface EmployeesService {
  
  List<Employees> fetchEmployee();

  List<Employees> fetchEmployeeByName(String employeeName);
  
  Employees createEmployee(int employeeId, String employeeName);

  Employees updateEmployee(int employeeId, String employeeName);
   
  void deleteEmployee(int employeeId);


}
