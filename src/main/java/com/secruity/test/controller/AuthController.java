package com.secruity.test.controller;

import com.secruity.test.dto.request.RegisterDTO;
import com.secruity.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterDTO payload) {
        try {
            userService.createNew(payload.getEmail(), payload.getPassword());
            return "user created successfully";
        } catch(Exception e) {
            return "something went wrong";
        }
    }
}
