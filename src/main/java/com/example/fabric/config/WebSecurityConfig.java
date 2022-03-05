package com.example.fabric.config;

import com.example.fabric.model.UserRole;
import com.example.fabric.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    public static final String POLL_PATH = "/polls";
    public static final String QUESTION_PATH = "/questions";
    public static final String ANSWER_PATH = "/answers";
    public static final String USER_PATH = "/users";
    public static final String ID_PATH = "/{id}";


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().and().sessionManagement().disable();

        http
                .authorizeRequests()
                .antMatchers(POST, POLL_PATH, QUESTION_PATH).hasAuthority(UserRole.ADMIN.name())
                .antMatchers(GET, POLL_PATH,
                        POLL_PATH + ID_PATH).hasAnyAuthority(UserRole.ADMIN.name(), UserRole.USER.name())
                .antMatchers(GET, ANSWER_PATH,
                        ANSWER_PATH + ID_PATH).hasAnyAuthority(UserRole.ADMIN.name(), UserRole.USER.name())
                .antMatchers(GET, QUESTION_PATH,
                        QUESTION_PATH + ID_PATH).hasAnyAuthority(UserRole.ADMIN.name(), UserRole.USER.name())
                .antMatchers(PUT, POLL_PATH + ID_PATH,
                        QUESTION_PATH + ID_PATH).hasAuthority(UserRole.ADMIN.name())
                .antMatchers(DELETE, POLL_PATH + ID_PATH,
                        QUESTION_PATH + ID_PATH).hasAuthority(UserRole.ADMIN.name())
                .and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService);
    }
}