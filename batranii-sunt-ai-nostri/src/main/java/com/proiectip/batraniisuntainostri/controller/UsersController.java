package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.Users;
import com.proiectip.batraniisuntainostri.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
