package com.example.luckpayapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "loan_accounts")
@Data
public class LoanAccount {

    @Id
    private String loanAccountNumber;
    private String dueDate;
    private Integer emiAmount;
}
