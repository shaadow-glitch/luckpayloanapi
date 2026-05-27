package com.example.luckpayapi.service;

import com.example.luckpayapi.dto.LoanResponseDto;

public interface LoanService {
    LoanResponseDto getLoanDetails(String loanAccountNumber);
}