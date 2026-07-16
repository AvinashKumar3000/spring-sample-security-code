package com.secruity.test.service;

import com.secruity.test.entity.User;
import com.secruity.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;

    public List<User> getAll() {
        List<User> li = userRepo.findAll();
        return li;
    }
}
