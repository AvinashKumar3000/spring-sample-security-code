package com.secruity.test.service;

import com.secruity.test.constants.Role;
import com.secruity.test.entity.User;
import com.secruity.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        List<User> li = userRepo.findAll();
        return li;
    }

    public void createNew(String email, String password) {
        String encryptedPass = passwordEncoder.encode(password);
        User newUser = User.builder()
                .email(email)
                .password(encryptedPass)
                .role(Role.USER)
                        .build();

            userRepo.save(newUser);
    }
}
