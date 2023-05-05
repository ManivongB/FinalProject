package com.promineotech.gamestore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.gamestore.dao.CustomerDao;
import com.promineotech.gamestore.entity.Customer;

@Service
public class DefaultCustomerService implements CustomerService{

  @Autowired
  private CustomerDao customerDao;

  @Transactional
  @Override
  public List<Customer> fetchCustomers() {
    List<Customer> customer = customerDao.fetchCustomers();
    
    return customer;
  }
  @Transactional
  @Override
  public List<Customer> fetchCustomerByFirstNameLastName(String customerFirstNameLastName) {
    List<Customer> customer = customerDao.
        fetchCustomerByFirstNameLastName(customerFirstNameLastName);
    
    return customer;
  }

  @Override
  public Customer createCustomer(String firstName, String lastName, String phoneNumber) {
    
  return customerDao.createCustomer(firstName, lastName, phoneNumber);
  }

  @Override
  public Customer updateCustomer(int customerId, String firstName, String lastName,
      String phoneNumber) {
    
    return customerDao.updateCustomer(customerId, firstName, lastName, phoneNumber);
  }

  @Override
  public void deleteCustomer(int customerId) {
    customerDao.deleteCustomer(customerId);
    
  }
  
  
}
