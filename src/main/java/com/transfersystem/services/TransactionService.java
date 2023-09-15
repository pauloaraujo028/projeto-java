package com.transfersystem.services;

import com.transfersystem.domain.transaction.Transaction;
import com.transfersystem.domain.user.User;
import com.transfersystem.dtos.TransactionDTO;
import com.transfersystem.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserService userService;

    public void createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        Transaction newTransaction = new Transaction();
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setAmount(transaction.value());


        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setAmount(transaction.value());

        newTransaction.setSender(sender);
        newTransaction.setTimestamp(java.time.LocalDateTime.now());

        this.repository.save(newTransaction);
    }
}

