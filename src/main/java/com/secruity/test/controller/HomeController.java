package com.secruity.test.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/", "/index"})
    public String indexPage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/user/dashboard")
    public String userDashboardPage() {
        return "/user/dashboard";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboardPage() {
        return "/admin/dashboard";
    }


    @GetMapping("/redirect-page")
    public String redirectLogin(Authentication auth) {
        boolean isAdmin = auth.getAuthorities()
                .stream()
                .anyMatch( authority ->
                        authority.getAuthority().equals("ROLE_ADMIN")
                );
        if(isAdmin) {
            return "redirect:/admin/dashboard";
        }else{
            return "redirect:/user/dashboard";
        }
    }

}
