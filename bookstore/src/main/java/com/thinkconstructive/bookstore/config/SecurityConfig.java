package com.thinkconstructive.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{

    @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails userDetailsOne = User.withUsername("Test99")
            .password(passwordEncoder().encode("pizza112")).build();
        UserDetails userDetailsTwo = User.withUsername("Test88")
            .password(passwordEncoder().encode("british44")).build();
        UserDetails adminUser = User.withUsername("admin")
            .password(passwordEncoder().encode("newFuture")).build();

        return new InMemoryUserDetailsManager(userDetailsOne, 
                userDetailsTwo, adminUser);
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    

}
