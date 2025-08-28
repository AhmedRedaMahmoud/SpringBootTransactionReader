package com.example.springbootcrudapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springbootcrudapi.entity.Transaction;
import com.example.springbootcrudapi.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransactionById(id);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/trans-id/{transId}")
    public ResponseEntity<Transaction> getTransactionByTransId(@PathVariable String transId) {
        Transaction transaction = transactionService.getTransactionByTransId(transId);
        return ResponseEntity.ok(transaction);
    }
}
