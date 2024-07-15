package com.esteban.forohub.repository;

import com.esteban.forohub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserRepository extends JpaRepository<User, Long> {
    UserDetails findByUserName(String username);

}
