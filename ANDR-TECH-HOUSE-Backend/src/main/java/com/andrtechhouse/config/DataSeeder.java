package com.andrtechhouse.config;

import com.andrtechhouse.model.Role;
import com.andrtechhouse.model.RoleName;
import com.andrtechhouse.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepo;

    @Override
    public void run(String... args) {
        for (RoleName rn : RoleName.values()) {
            roleRepo.findByName(rn)
                    .orElseGet(() -> roleRepo.save(new Role(null, rn)));
        }
    }
}
