    package com.example.demo.io;

    import lombok.Builder;
    import lombok.Getter;

    @Getter

    @Builder
    public class Authresp {
        String email;
        String token;
        String role;
    }
