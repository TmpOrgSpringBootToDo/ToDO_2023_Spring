package com.thanu.work.todo2023.config;

import com.thanu.work.todo2023.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private UserDTO userDTO;

    @Bean
    //authentication
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails authUser = User.withUsername("Bimal")
                .password(encoder.encode("tests@202255"))
                .roles("AUTHUSER")
                .build();
        return new InMemoryUserDetailsManager(authUser);
   }

    //autherization
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
                    return httpSecurity.csrf().disable()
                    .authorizeHttpRequests()
                    .requestMatchers("/users").permitAll()
                    .and()
                    .authorizeHttpRequests().requestMatchers("/users/**").authenticated()
                    .and().formLogin()
                    .and().build();
    }
   @Bean
   public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
   }



}
