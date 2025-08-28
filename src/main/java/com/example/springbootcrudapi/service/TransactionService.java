package com.example.springbootcrudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootcrudapi.entity.Transaction;
import com.example.springbootcrudapi.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Transaction not found with id: " + id));
    }

    public Transaction getTransactionByTransId(String transId) {
        return transactionRepository.findByTransId(transId)
            .orElseThrow(() -> new EntityNotFoundException("Transaction not found with transId: " + transId));
    }
}
