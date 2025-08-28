package com.example.springbootcrudapi.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Transaction Entity for HR.MD_TRANSACTION_CURRENT table
 * This entity maps to the HR.MD_TRANSACTION_CURRENT table in Oracle Database
 */
@Entity
@Table(name = "MD_TRANSACTION_CURRENT", schema = "HR")
@org.hibernate.annotations.Immutable // Mark as read-only
public class Transaction {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "TRANS_ID", length = 50)
    private String transId;

    @Column(name = "TERMINAL_ID", length = 20)
    private String terminalId;

    @Column(name = "MERCHANT_NAME", length = 100)
    private String merchantName;

    @Column(name = "SOURCE_AMOUNT", precision = 15, scale = 2)
    private BigDecimal sourceAmount;

    @Column(name = "MERCHANT_COMMISSION", precision = 15, scale = 2)
    private BigDecimal merchantCommission;

    @Column(name = "TRANSACTION_DATE")
    private LocalDateTime transactionDate;

    @Column(name = "PROCESSING_DATE")
    private LocalDateTime processingDate;

    @Column(name = "MASK_PAN", length = 20)
    private String maskPan;

    @Column(name = "AUTHORIZATION_NUMBER", length = 20)
    private String authorizationNumber;

    @Column(name = "MERCHANT_ACCOUNT_NUMBER", length = 30)
    private String merchantAccountNumber;

    @Column(name = "OUTLET_CODE", length = 20)
    private String outletCode;

    // Getters
    public Long getId() {
        return id;
    }

    public String getTransId() {
        return transId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public BigDecimal getSourceAmount() {
        return sourceAmount;
    }

    public BigDecimal getMerchantCommission() {
        return merchantCommission;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public LocalDateTime getProcessingDate() {
        return processingDate;
    }

    public String getMaskPan() {
        return maskPan;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    public String getMerchantAccountNumber() {
        return merchantAccountNumber;
    }

    public String getOutletCode() {
        return outletCode;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transId='" + transId + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", sourceAmount=" + sourceAmount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
