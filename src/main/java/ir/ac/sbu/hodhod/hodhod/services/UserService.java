package ir.ac.sbu.hodhod.hodhod.services;

import ir.ac.sbu.hodhod.hodhod.models.User;

import java.util.Optional;

public interface UserService {
    public Optional<User> findByEmail(String email);
}
