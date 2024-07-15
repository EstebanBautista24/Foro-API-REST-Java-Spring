package com.esteban.forohub.Controller;

import com.esteban.forohub.model.DTO.LoginUser;
import com.esteban.forohub.model.DTO.RegisterUser;
import com.esteban.forohub.model.User;
import com.esteban.forohub.service.TokenService;
import com.esteban.forohub.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<RegisterUser> userRegister(@RequestBody @Valid RegisterUser registerUser){
        userService.SaveUser(registerUser);
        HttpHeaders headers = new HttpHeaders();

        return   ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(registerUser);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginUser loginUser){
        Authentication authToken = new UsernamePasswordAuthenticationToken(loginUser.getUsername(),loginUser.getPassword());
        Authentication usuarioAutenticado =  authenticationManager.authenticate(authToken);
        String token = tokenService.generateToken((User) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(token);
    }


}
