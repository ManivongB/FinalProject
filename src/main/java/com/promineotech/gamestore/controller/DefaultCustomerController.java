package com.promineotech.gamestore.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.gamestore.entity.Customer;
import com.promineotech.gamestore.entity.Dto.CustomerDto;
import com.promineotech.gamestore.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCustomerController implements CustomerController{

  @Autowired
  private CustomerService customerService;
  
  @Override
  public List<Customer> fetchCustomers() {
    
    return customerService.fetchCustomers();
  }

  @Override
  public List<Customer> fetchCustomerByFirstNameLastNameCustomers(
      String customerFirstNameLastNameString) {
    
    return customerService.fetchCustomerByFirstNameLastName(
        customerFirstNameLastNameString);
  }

  @Override
  public Customer createCustomer(@Valid CustomerDto customerDto) {
    
    return customerService.createCustomer(customerDto.getFirstName(),
        customerDto.getLastName(), customerDto.getPhoneNumber());
  }

  @Override
  public Customer updateCustomer(@Valid CustomerDto customerDto) {
    
    return customerService.updateCustomer(customerDto.getCustomerId(), 
        customerDto.getFirstName(), customerDto.getLastName(), customerDto.getPhoneNumber());
  }

  @Override
  public void deleteCustomer(@Valid CustomerDto customerDto) {
    log.debug("Customer ID Deleted = {}", customerDto.getCustomerId());
    customerService.deleteCustomer(customerDto.getCustomerId());
    
  }

}
