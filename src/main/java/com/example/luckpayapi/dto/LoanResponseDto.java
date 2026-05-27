package com.example.luckpayapi.dto;

import lombok.Data;

@Data
public class LoanResponseDto {

    private String loanAccountNumber;
    private String dueDate;
    private Integer emiAmount;
}
