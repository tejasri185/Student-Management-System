package net.javaguides.sms.service;

import net.javaguides.sms.entity.User;
import net.javaguides.sms.repository.UserRepository;
import net.javaguides.sms.security.CustomUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails(user);
    }
}
