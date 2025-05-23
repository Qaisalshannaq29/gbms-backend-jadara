//package com.gpms.backend.services.Role.controller;
//
//import com.gpms.backend.entity.Role;
//import com.gpms.backend.services.Role.repository.RoleRepository;
//import com.gpms.backend.services.Role.service.roleValidation. RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/roles")
//public      class RoleController {
//
//    private final RoleRepository roleRepository;
//    private final RoleService roleService;
//
//    public RoleController(RoleRepository roleRepository, RoleService roleService) {
//        this.roleRepository = roleRepository;
//        this.roleService = roleService;
//    }
//
//    @GetMapping
//    public List<Role> getAllRoles() {
//        return roleRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Role> getRoleById(@PathVariable long id) {
//        return roleRepository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Role> createRole(@RequestBody Role role) {
//         created = roleService.
//        return ResponseEntity.ok(created);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Role> updateRole(@PathVariable long id, @RequestBody Role updatedRole) {
//
//    }
//}
