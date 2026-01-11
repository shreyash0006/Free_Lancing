package com.example.demo.controller;

import com.example.demo.io.Authreq;
import com.example.demo.io.Authresp;
import com.example.demo.jwtutil.JwtUtil;
import com.example.demo.service.userservice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/access")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    PasswordEncoder pass;
    @Autowired
    AuthenticationManager mang;
    @Autowired
    JwtUtil jwt;
    @Autowired
    UserDetailsService uds;
    @Autowired
    userservice userservice;
    @PostMapping("/login")
    public Authresp get(@RequestBody Authreq authreq)
    {
        authenticate(authreq.getEmail(),authreq.getPassword());
        UserDetails u=uds.loadUserByUsername(authreq.getEmail());
        String token=jwt.generateToken(u);
        String role=userservice.getrole(authreq.getEmail()).toUpperCase();
        return  Authresp.builder().email(authreq.getEmail()).token(token).role(role).build();
    }

    private void authenticate(String email, String password) {
       try{
           mang.authenticate(new UsernamePasswordAuthenticationToken(email,password));
       }
       catch(Exception e)
       {
           throw new RuntimeException("Error occured"+e);
       }
    }

    @PostMapping("/encode")
    public String encode(@RequestBody Map<String,String> m)
    {
        return pass.encode(m.get("password"));
    }
}
