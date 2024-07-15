package com.esteban.forohub.model;


import com.esteban.forohub.model.DTO.LoginUser;
import com.esteban.forohub.model.DTO.RegisterUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "userforo")
@Table(name = "userforo")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String name;
    private String userName;
    private String email;
    private String password;
    @OneToMany(mappedBy = "author")
    List<Topic> topics;
    @OneToMany(mappedBy = "author")
    List<Response> responses;
    public User(RegisterUser registerUser) {
        this.name = registerUser.getName();
        this.email = registerUser.getEmail();
        this.userName = registerUser.getUsername();
    }
    public User(LoginUser loginUser) {
        this.userName = loginUser.getUsername();
        this.password = loginUser.getPassword();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
    @Override
    public String getPassword() {
        return password;
    }
}
