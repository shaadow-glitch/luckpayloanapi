package com.example.luckpayapi.repository;

import com.example.luckpayapi.entity.LoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanAccount, String> {
}