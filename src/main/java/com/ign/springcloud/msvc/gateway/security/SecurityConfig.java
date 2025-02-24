package com.ign.springcloud.msvc.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        return http.authorizeExchange(auth -> {
            auth.pathMatchers("/authorized", "/logout").permitAll()
                    .pathMatchers(HttpMethod.GET, "/api/items", "/api/products", "/api/users").permitAll()
                    .pathMatchers(HttpMethod.GET, "/api/items/{id}", "/api/products/{id}", "/api/users/{id}")
                    .hasAnyRole("USER", "ADMIN")
                    .pathMatchers("/api/products/**", "/api/items/**", "/api/users/**").hasRole("ADMIN")
                    .pathMatchers(HttpMethod.POST, "/api/products/**", "/api/items/**", "/api/users/**")
                    .hasRole("ADMIN")
                    .pathMatchers(HttpMethod.PUT, "/api/products/**", "/api/items/**", "/api/users/**").hasRole("ADMIN")
                    .pathMatchers(HttpMethod.DELETE, "/api/products/**", "/api/items/**", "/api/users/**")
                    .hasRole("ADMIN")
                    .anyExchange().authenticated();
        }).cors(csrf -> csrf.disable())
                .oauth2Login(withDefaults())
                .oauth2Client(withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()))
                .build();
    }

   /*  @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((authz) -> {
            authz
                    .requestMatchers("/authorized", "/logout").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/products", "/api/items", "/api/users").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/products/{id}", "/api/items/{id}", "/api/users/{id}")
                    .hasAnyRole("ADMIN", "USER")
                    .requestMatchers("/api/products/**", "/api/items/**", "/api/users/**").hasRole("ADMIN")
                    .anyRequest().authenticated();
        })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .oauth2Login(login -> login.loginPage("/oauth2/authorization/client-app"))
                .oauth2Client(withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()))
                .build();
    } */
}
