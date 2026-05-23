package net.javaguides.sms.service.impl;

import net.javaguides.sms.entity.User;
import net.javaguides.sms.repository.UserRepository;
import net.javaguides.sms.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public User saveUser(User user) { return userRepository.save(user); }

    @Override
    public boolean existsByEmail(String email) { return userRepository.existsByEmail(email); }

    @Override
    public User findByEmail(String email) { return userRepository.findByEmail(email); }

    @Override
    public long countUsers() { return userRepository.count(); }

    @Override
    public User findByUsername(String username) {
        // username is email in this project
        return userRepository.findByEmail(username);
    }
}