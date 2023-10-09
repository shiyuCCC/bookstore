package com.programming3final.bookstore.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource) { // inject data source auto-configured by
                                                                          // Spring Boot
        return new JdbcUserDetailsManager(datasource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer

                .requestMatchers("/showRegistration").permitAll()
                .requestMatchers("/").hasRole("CUSTOMER")
                .requestMatchers("/staff/**").hasRole("STAFF")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl(("/authenticateTheUser"))
                        .permitAll())
                .logout(logout -> logout.permitAll())
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied")

                );

        return http.build();

    }
}
