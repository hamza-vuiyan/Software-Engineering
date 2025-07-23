package com.amir.SpringCRUD;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return repo.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @GetMapping("/{email}")
    public User getUser(@PathVariable String email) {
        return repo.findById(email).orElse(null);
    }

    @PutMapping("/{email}")
    public User updateUser(@PathVariable String email, @RequestBody User newUser) {
        return repo.findById(email).map(user -> {
            user.setPassword(newUser.getPassword());
            return repo.save(user);
        }).orElse(null);
    }

    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable String email) {
        repo.deleteById(email);
    }


}
