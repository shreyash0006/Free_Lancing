package com.example.demo.io;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Authreq {
    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
