package com.example.demoGradleSecurity.rest;

import com.example.demoGradleSecurity.dto.AuthenticationRequestDto;
import com.example.demoGradleSecurity.entity.UserEntity;
import com.example.demoGradleSecurity.security.jwt.JwtTokenProvider;
import com.example.demoGradleSecurity.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/api/v1/auth", method = { RequestMethod.GET, RequestMethod.POST })
public class AuthenticationRestControllerV1 {
//    private SecurityFilterChain securityFilterChain;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @Autowired
    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
//        this.securityFilterChain = securityFilterChain;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
//        System.out.println("ssss");
//        try {
//            System.out.println("login in");
//            String username = requestDto.getUsername();
//            System.out.println("login 1"+username);
//            securityFilterChain.getFilters().
////            securityFilterChain.matches((HttpServletRequest) requestDto);
//            System.out.println("login 2");
////            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
//            UserEntity user = userService.findByName(username);
//            System.out.println(user.getName());
//
//            if (user == null) {
//                throw new UsernameNotFoundException("User with username: " + username + " not found!");
//            }
//
//            String token = jwtTokenProvider.createToken(username, user.getRoles());
//
//            Map<Object, Object> response = new HashMap<>();
//            response.put("username", username);
//            response.put("token", token);
//
//            return ResponseEntity.ok(response);
//        } catch (AuthenticationException e) {
//            throw new BadCredentialsException("Invalid username or password " + e);
//        }
//    }

//    @GetMapping("/login")
//    public String loginEndpoint(@RequestBody AuthenticationRequestDto requestDto) {
//        System.out.println(requestDto.getUsername());
//        return "Login!";
//    }
    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {

        try {
//        System.out.println("1");
//        System.out.println(requestDto.getUsername());
//        System.out.println(requestDto.getPassword());

        String username = requestDto.getUsername();
            System.out.println("1");

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken((Object) username, (Object) requestDto.getPassword()));
            System.out.println("2");

        UserEntity user = userService.findByName(requestDto.getUsername());
            System.out.println(user.getName()+"xxxxxx");

        if(user == null) {
//            System.out.println("ERROR USER NULL");
            throw new UsernameNotFoundException("User with username: "+ username + " not found!");
        }

//        System.out.println(user.getName());
//        System.out.println(user.getPassword());


        String token = jwtTokenProvider.createToken(username, user.getRoles());
            System.out.println(token+" TOOOOOOOKEN");
//        System.out.println(authentication.
//        getPrincipal());

        Map<Object, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("token", token);

        return ResponseEntity.ok(response);

    } catch (AuthenticationException e) {
            System.out.println(e);
        throw new BadCredentialsException("Invalid username or password "+e);
    }
    }
}
