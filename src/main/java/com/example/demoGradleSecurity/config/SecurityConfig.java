package com.example.demoGradleSecurity.config;

import com.example.demoGradleSecurity.security.jwt.JwtConfigurer;
import com.example.demoGradleSecurity.security.jwt.JwtTokenFilter;
import com.example.demoGradleSecurity.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String ADMIN_ENDPOINT = "/api/v1/admin/**";
    private static final String LOGIN_ENDPOINT = "/api/v1/auth/login";

//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return authenticationManagerBean();
//    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          http

//                .formLogin(form -> form.loginPage(LOGIN_ENDPOINT).permitAll())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(LOGIN_ENDPOINT).permitAll()
                        .requestMatchers(ADMIN_ENDPOINT).permitAll()
                        .anyRequest().authenticated())
                        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // (3)
                        .httpBasic(Customizer.withDefaults());
          http.addFilterBefore(new JwtTokenFilter(new JwtTokenProvider()), UsernamePasswordAuthenticationFilter.class);

          return http.build();
//                        .requestMatchers(ADMIN_ENDPOINT).authenticated()
//                        .anyRequest().authenticated()).build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    { return authenticationConfiguration.getAuthenticationManager();}

//    @Bean
//    public PasswordEncoder passwordEncoder()
//    { return new BCryptPasswordEncoder(); }

}
