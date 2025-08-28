package com.example.springbootcrudapi.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Application configuration for read-only operations on HR.MD_TRANSACTION_CURRENT
 */
@Configuration
@EnableTransactionManagement
@EntityScan("com.example.springbootcrudapi.entity")
@EnableJpaRepositories("com.example.springbootcrudapi.repository")
public class AppConfig {
}
