package com.hexaware.entity;

import java.util.List;
import java.util.ArrayList;

public class AdminService implements IAdminService {
    private List<Admin> admins = new ArrayList<>(); // Simulating a database

    @Override
    public Admin getAdminById(int adminID) {
        for (Admin admin : admins) {
            if (admin.getAdminID() == adminID) {
                return admin;
            }
        }
        return null; // Admin not found
    }

    @Override
    public Admin getAdminByUsername(String username) {
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username)) {
                return admin;
            }
        }
        return null; // Admin not found
    }

    @Override
    public void registerAdmin(Admin admin) {
        admins.add(admin); // Add admin to the list (DB simulation)
    }

    @Override
    public void updateAdmin(Admin updatedAdmin) {
        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).getAdminID() == updatedAdmin.getAdminID()) {
                admins.set(i, updatedAdmin); // Update admin
                return;
            }
        }
    }

    @Override
    public void deleteAdmin(int adminID) {
        admins.removeIf(admin -> admin.getAdminID() == adminID); // Remove admin
    }
}

