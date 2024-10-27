package com.hexaware.entity;

public interface IAdminService {
    Admin getAdminById(int adminId);
    Admin getAdminByUsername(String username);
    void registerAdmin(Admin adminData);
    void updateAdmin(Admin adminData);
    void deleteAdmin(int adminId);
}
