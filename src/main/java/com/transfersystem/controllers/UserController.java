package com.transfersystem.controllers;

import com.transfersystem.domain.user.User;
import com.transfersystem.domain.user.UserType;
import com.transfersystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(
            @RequestParam String name,
            @RequestParam String document,
//            @RequestParam BigDecimal balance,
            @RequestParam String userType
    ) {
        try {
            User user = new User();
            user.setName(name);
            user.setDocument(document);
//            user.setBalance(balance);
            user.setUserType(UserType.valueOf(userType));

            userService.saveUser(user);

            return ResponseEntity.ok("User created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user: " + e.getMessage());
        }
    }
}
