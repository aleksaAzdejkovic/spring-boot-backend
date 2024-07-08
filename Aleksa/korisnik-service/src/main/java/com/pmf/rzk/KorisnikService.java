package com.pmf.rzk;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmf.rzk.model.UsersAzd;
import com.pmf.rzk.repository.KorisnikRepo;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepo userRepository;

   

    public UsersAzd registerUser(UsersAzd user) {
        return userRepository.save(user);
    }

    public Optional<UsersAzd> loginUser(String email, String password) {
    	Optional<UsersAzd> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }

    public UsersAzd updateUser(Integer id, UsersAzd userDetails) {
        UsersAzd user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setBalance(userDetails.getBalance());
        return userRepository.save(user);
    }
}