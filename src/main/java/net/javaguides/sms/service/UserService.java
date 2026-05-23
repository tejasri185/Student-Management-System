package net.javaguides.sms.service;

import net.javaguides.sms.entity.User;

public interface UserService {

    User saveUser(User user);

    boolean existsByEmail(String email);

    User findByEmail(String email);

    long countUsers();   // ✅ Added for dashboard

    User findByUsername(String username);
    }