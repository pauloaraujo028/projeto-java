package com.transfersystem.controllers;

import com.transfersystem.dtos.TransactionDTO;
import com.transfersystem.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<String> createTransaction(
            @RequestParam Long senderId,
            @RequestParam Long receiverId,
            @RequestParam BigDecimal value
    ) {
        try {
            TransactionDTO transaction = new TransactionDTO(value, senderId, receiverId);
            transactionService.createTransaction(transaction);

            return ResponseEntity.ok("Transaction created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating transaction: " + e.getMessage());
        }
    }
}
