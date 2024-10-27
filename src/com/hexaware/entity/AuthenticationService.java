package com.hexaware.entity;

public class AuthenticationService {
    private CustomerService customerService;
    private AdminService adminService;

    public AuthenticationService(CustomerService customerService, AdminService adminService) {
        this.customerService = customerService;
        this.adminService = adminService;
    }

    public boolean authenticateCustomer(String username, String password) {
        Customer customer = customerService.getCustomerByUsername(username);
        return customer != null && customer.authenticate(password);
    }

    public boolean authenticateAdmin(String username, String password) {
        Admin admin = adminService.getAdminByUsername(username);
        return admin != null && admin.authenticate(password);
    }
}

