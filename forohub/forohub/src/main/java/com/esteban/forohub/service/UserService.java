package com.esteban.forohub.service;

import com.esteban.forohub.model.DTO.RegisterUser;
import com.esteban.forohub.model.User;
import com.esteban.forohub.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService implements UserDetailsService {


    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    IUserRepository userRepository;

    public UserService(@Autowired IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void SaveUser(RegisterUser user) {
        User newUser = new User(user);
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(newUser);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username);
    }
    public UserDetails findByUsername(String username) {
        return userRepository.findByUserName(username);
    }
    public User findById(Long id) {
        return userRepository.getReferenceById(id);
    }

}
