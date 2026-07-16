package com.secruity.test.seeder;

import com.secruity.test.constants.Role;
import com.secruity.test.entity.User;
import com.secruity.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserSeeder implements CommandLineRunner {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        long length = userRepo.count();
        if(length == 0) {
            User u1 = User.builder()
                    .email("sample@gmail.com")
                    .password(passwordEncoder.encode("sample"))
                    .role(Role.USER)
                    .build();
            User u2 = User.builder()
                    .email("admin@gmail.com")
                    .password(passwordEncoder.encode("admin"))
                    .role(Role.ADMIN)
                    .build();
            List<User> li = List.of(u1, u2);
            userRepo.saveAll(li);
        }

    }
}
