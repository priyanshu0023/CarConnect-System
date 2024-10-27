package com.hexaware.entity;


import java.util.List;
import java.util.ArrayList;

public class CustomerService implements ICustomerService {
    private List<Customer> customers = new ArrayList<>(); // Simulating a database

    public Customer getCustomerById(int customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    @Override
    public void registerCustomer(Customer customer) {
        customers.add(customer); // Add customer to the list (DB simulation)
    }

    @Override
    public void updateCustomer(Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerID() == updatedCustomer.getCustomerID()) {
                customers.set(i, updatedCustomer); // Update customer
                return;
            }
        }
    }

    @Override
    public void deleteCustomer(int customerID) {
        customers.removeIf(customer -> customer.getCustomerID() == customerID); // Remove customer from the list
    }

	public static void RegisterCustomer(Customer newCustomer) {
		// TODO Auto-generated method stub
		
	}
}
