package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.Users;
import com.proiectip.batraniisuntainostri.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @CrossOrigin
    @GetMapping("/users")
    public ResponseEntity<Users> verificaDate(@RequestParam("username") String username,
                                              @RequestParam("password") String password) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(usersService.verificaDateLogin(username, password));
    }

    @CrossOrigin
    @PostMapping("/inregistreaza")
    public ResponseEntity<Void> adaugaUser(@RequestParam("username") String username,
                                           @RequestParam("password") String password,
                                           @RequestBody Users users) throws ExecutionException, InterruptedException {
        usersService.adaugaUser(users);
        return ResponseEntity.noContent().build();
    }
}
