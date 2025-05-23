package com.gpms.backend.services.Role.service.Impl;

import com.gpms.backend.services.Role.service.roleValidation.RoleService;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

public class roleServiceImpl implements RoleService {
    @Override
    public List<Role> findAll() {
        return List.of();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {


    }
}
