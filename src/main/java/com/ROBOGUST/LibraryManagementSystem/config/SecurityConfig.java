package com.ROBOGUST.LibraryManagementSystem.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final ApplicationConfig applicationConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**", "/login", "/register" )
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //.sessionManagement()
                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .and()
                .rememberMe()
                .key("SECRET_KEY" ) // Key for token validity
                .rememberMeParameter ("remember-me" )
                .and()
                .logout()
                .logoutUrl("/logout") // TODO - Somehow gets POSTed to logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/login")
                .and()
                .authenticationProvider(applicationConfig.authenticationProvider()) // <-- TODO - DaoAuthenticationProvider
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}
