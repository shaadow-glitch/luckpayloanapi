package com.example.luckpayapi.controller;

import com.example.luckpayapi.dto.LoanResponseDto;
import com.example.luckpayapi.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping("/{loanAccountNumber}")
    public LoanResponseDto getLoanDetails(
            @PathVariable String loanAccountNumber
    ) {

        return loanService.getLoanDetails(loanAccountNumber);
    }
}