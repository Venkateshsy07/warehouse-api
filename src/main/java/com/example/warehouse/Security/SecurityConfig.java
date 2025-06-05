package com.example.warehouse.Security;

import com.example.warehouse.Security.Filters.ClientAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, ClientAuthFilter clientAuthFilter) throws Exception {

        return http.csrf(csrf -> csrf.disable())


                //authentication of endpoints as private and public
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/client/register").permitAll()
                        .anyRequest().authenticated()
                ).addFilterBefore(clientAuthFilter, UsernamePasswordAuthenticationFilter.class)

                //type of the authentication to user [http basic,from login,AuthOLogin]
                .formLogin(Customizer.withDefaults())

                //building
                .build();
    }

}
