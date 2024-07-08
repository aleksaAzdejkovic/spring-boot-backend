package com.pmf.rzk;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmf.rzk.model.UsersAzd;

@RestController
@RequestMapping("/users")
public class KorisnikController {
	@Autowired
    private KorisnikService userService;

	@PostMapping("/register")
    public ResponseEntity<UsersAzd> registerUser(@RequestBody UsersAzd user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UsersAzd> loginUser(@RequestParam String email, @RequestParam String password) {
        Optional<UsersAzd> user = userService.loginUser(email, password);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(401).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersAzd> updateUser(@PathVariable Integer id, @RequestBody UsersAzd userDetails) {
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }
}
