package net.javaguides.sms.service.impl;

import org.springframework.stereotype.Service;
import net.javaguides.sms.entity.Role;
import net.javaguides.sms.repository.RoleRepository;
import net.javaguides.sms.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
