package com.promineotech.gamestore.service;

import java.util.List;
import com.promineotech.gamestore.entity.Customer;

public interface CustomerService {
  
  
  List<Customer> fetchCustomers();

  List<Customer> fetchCustomerByFirstNameLastName(String customerFirstNameLastName);

  
  Customer createCustomer(String firstName, String lastName, String phoneNumber);

  
  
  Customer updateCustomer(int customerId, String firstName, String lastName,
      String phoneNumber);
  
 
  void deleteCustomer(int customerId);
}
