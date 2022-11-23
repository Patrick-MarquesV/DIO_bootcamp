package com.firstWebRestAPI.config;


import com.firstWebRestAPI.service.SecurityDataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig{

    @Autowired
    private SecurityDataBaseService sercurityService;

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(sercurityService).passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/manager").hasAnyRole("MANAGERS")
                .antMatchers("/user", "/users").hasAnyRole("USERS", "MANAGERS")
                .anyRequest().authenticated().and().httpBasic();

        return http.build();
    }


//  COMENTADO POIS AGORA ARMAZENAREMOS OS USUÁRIOS NA DB
//    @Bean
//    public UserDetailsService users() {
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        UserDetails user = users
//                .username("user")
//                .password("abc@123")
//                .roles("USERS")
//                .build();
//        UserDetails admin = users
//                .username("admin")
//                .password("abc@1234")
//                .roles("MANAGERS")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}
