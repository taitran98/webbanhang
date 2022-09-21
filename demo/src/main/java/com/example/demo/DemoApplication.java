package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    public static class CustomPasswordEncoder implements PasswordEncoder {
        @Override
        public String encode(CharSequence plainTextPassword) {
            return BCrypt.hashpw(plainTextPassword.toString(),BCrypt.gensalt(8));
        }

        @Override
        public boolean matches(CharSequence plainTextPassword, String passwordInDatabase) {
            return BCrypt.checkpw(plainTextPassword.toString(),passwordInDatabase);
        }
    }
}
