package com.library.controller;
import com.library.entity.User;
import com.library.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/users") @CrossOrigin("*")
public class UserController {
 private final UserRepository repo;
 public UserController(UserRepository repo){this.repo=repo;}
 @GetMapping public List<User> all(){return repo.findAll();}
 @PostMapping("/register") public User register(@RequestBody User u){return repo.save(u);}
 @PostMapping("/login") public String login(@RequestBody User u){
  return repo.findByEmail(u.getEmail()).filter(x->x.getPassword().equals(u.getPassword()))
  .map(x->"Login successful").orElse("Invalid email or password");
 }
}