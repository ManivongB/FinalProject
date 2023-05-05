package com.promineotech.gamestore.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.gamestore.entity.Employees;
import com.promineotech.gamestore.entity.Dto.EmployeesDto;
import com.promineotech.gamestore.service.EmployeesService;

@RestController
public class DefaultEmployeeController implements EmployeesController {

  @Autowired
  private EmployeesService employeesService;
  
  @Override
  public List<Employees> fetchEmployee() {
    
    return employeesService.fetchEmployee();
  }

  @Override
  public List<Employees> fetchEmployeeByName(String employeeName) {
    
    return employeesService.fetchEmployeeByName(employeeName);
  }

  @Override
  public Employees createEmployee(@Valid EmployeesDto employeesDto) {
    
    return employeesService.createEmployee(employeesDto.getEmployeeId(), null);
  }

  @Override
  public Employees updateEmployee(@Valid EmployeesDto employeesDto) {
    
    return employeesService.updateEmployee(employeesDto.getEmployeeId(), null);
  }

  @Override
  public void deleteEmployee(@Valid EmployeesDto employeesDto) {
    employeesService.deleteEmployee(employeesDto.getEmployeeId());
    
  }

}
