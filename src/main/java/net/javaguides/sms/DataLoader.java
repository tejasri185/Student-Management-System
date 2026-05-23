package net.javaguides.sms;

import net.javaguides.sms.entity.Role;
import net.javaguides.sms.entity.User;
import net.javaguides.sms.repository.RoleRepository;
import net.javaguides.sms.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        if (roleRepository.findByName("ROLE_ADMIN") == null)
            roleRepository.save(new Role("ROLE_ADMIN"));

        if (roleRepository.findByName("ROLE_USER") == null)
            roleRepository.save(new Role("ROLE_USER"));

        if (!userRepository.existsByEmail("admin@gmail.com")) {
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRoles(Set.of(roleRepository.findByName("ROLE_ADMIN")));
            userRepository.save(admin);
        }
    }
}
