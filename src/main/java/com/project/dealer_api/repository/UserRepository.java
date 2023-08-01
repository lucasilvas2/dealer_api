package com.project.dealer_api.repository;

import com.project.dealer_api.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users, Integer> {
    UserDetails findByLogin(String login);
}
