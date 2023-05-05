package com.promineotech.gamestore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.gamestore.dao.EmployeesDao;
import com.promineotech.gamestore.entity.Employees;

@Service
public class DefaultEmployeesService implements EmployeesService{
  
  @Autowired
  private EmployeesDao employeesDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Employees> fetchEmployee() {
    List<Employees> employees = employeesDao.fetchEmployees();
    return employees;
  }
  
  @Transactional(readOnly = true)
  @Override
  public List<Employees> fetchEmployeeByName(String employeeName) {
    List<Employees>employees = employeesDao.fetchEmployeeByName(employeeName);
    return employees;
  }

  @Override
  public Employees createEmployee(int employeeId, String employeeName) {
    
    return employeesDao.createEmployee(employeeId, employeeName);
  }

  @Override
  public Employees updateEmployee(int employeeId, String employeeName) {
    
    return employeesDao.updateEmployee(employeeId, employeeName);
  }

  @Override
  public void deleteEmployee(int employeeId) {
    
    employeesDao.deleteEmployee(employeeId);
    
  }
  
  

}
