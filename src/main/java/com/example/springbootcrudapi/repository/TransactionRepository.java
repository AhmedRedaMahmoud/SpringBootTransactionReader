package com.example.springbootcrudapi.repository;

import com.example.springbootcrudapi.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

/**
 * Repository for read-only operations on HR.MD_TRANSACTION_CURRENT
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    /**
     * Find a transaction by its transaction ID
     */
    Optional<Transaction> findByTransId(String transId);

    /**
     * Find a transaction by its authorization number
     */
    Optional<Transaction> findByAuthorizationNumber(String authorizationNumber);
}
