package com.hexaware.entity;

public interface ICustomerService {
    Customer getCustomerById(int customerId);
    Customer getCustomerByUsername(String username);
    void registerCustomer(Customer customerData);
    void updateCustomer(Customer customerData);
    void deleteCustomer(int customerId);
}
