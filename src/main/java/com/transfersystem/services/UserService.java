package com.transfersystem.services;

import com.transfersystem.domain.user.User;
import com.transfersystem.domain.user.UserType;
import com.transfersystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.COMPANY) {
            throw new Exception("Usuário do tipo Empresa não está autorizado a realizar transação!");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente!");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public void saveUser(User user) throws Exception {
        if(!validateDocument(user.getDocument(), user.getUserType())){
            throw new Exception("CPF/CNPJ inválido");
        }
        this.repository.save(user);
    }

    private boolean validateDocument(String document, UserType userType) {
        document = document.replaceAll("[^0-9]", "");

        return (userType != UserType.COMMON || document.length() == 11) && ((userType != UserType.COMPANY || document.length() == 14));
    }
}
