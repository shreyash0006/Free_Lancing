    package com.example.demo.io;

    import lombok.*;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class usereq {
        String email;
        String password;
        String name;
        String role;

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }
    }
