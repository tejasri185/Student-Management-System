package net.javaguides.sms.service;

import net.javaguides.sms.entity.Role;

public interface RoleService {
    Role saveRole(Role role);
    Role findByName(String name);
}
