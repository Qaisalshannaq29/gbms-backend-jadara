package com.gpms.backend.services.user.repoisitory;

import com.gpms.backend.entity.User;
import jdk.jfr.Registered;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    User findByEmail(String email);
}
