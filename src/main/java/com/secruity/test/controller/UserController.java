package com.secruity.test.controller;

import com.secruity.test.entity.User;
import com.secruity.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public List<?> getAllUsers() {
        List<User> li= userService.getAll();
        return li;
    }

}
