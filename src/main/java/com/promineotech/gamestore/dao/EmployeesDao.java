package com.promineotech.gamestore.dao;

import java.util.List;
import com.promineotech.gamestore.entity.Employees;

public interface EmployeesDao {

  List<Employees> fetchEmployees();

  List<Employees> fetchEmployeeByName(String employeeName);

  Employees createEmployee(int employeeId, String employeeName);

  Employees updateEmployee(int employeeId, String employeeName);

  void deleteEmployee(int employeeId);

}
