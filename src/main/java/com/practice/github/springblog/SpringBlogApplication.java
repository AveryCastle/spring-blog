package com.practice.github.springblog;

import com.practice.github.springblog.entities.CustomerUserDetail;
import com.practice.github.springblog.entities.Role;
import com.practice.github.springblog.entities.User;
import com.practice.github.springblog.repositories.UserRepository;
import com.practice.github.springblog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class SpringBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBlogApplication.class, args);
    }

    @Bean
    public CommandLineRunner setupDefaultUser(UserService service) {
        return args -> {
            service.save(new User(
                    "user", //username
                    "user", //password
                    Arrays.asList(new Role("USER"), new Role("ACTUATOR")),//roles
                    true//Active
            ));
        };
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

