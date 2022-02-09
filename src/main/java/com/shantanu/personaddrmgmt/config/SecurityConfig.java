/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shantanu.personaddrmgmt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 *
 * @author shantanu
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    
    @Value("${spring.security.user.name}")
    String username;
    
    @Value("${spring.security.user.password}")
    String password;
    
    @Value("${spring.security.user.role}")
    String role;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
            .and()
                .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService()
    {
        UserDetails user = User.withDefaultPasswordEncoder()
                        .username(username)
                        .password(password)
                        .roles(role)
                        .build();
        
        return new InMemoryUserDetailsManager(user);
    }
    
    
    
    
}
