package com.example.luckpayapi.service;

import com.example.luckpayapi.client.LoanApiClient;
import com.example.luckpayapi.dto.LoanApiResponseDto;
import com.example.luckpayapi.dto.LoanResponseDto;
import com.example.luckpayapi.entity.LoanAccount;
import com.example.luckpayapi.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService{

    private final LoanApiClient loanApiClient;
    private final LoanRepository loanRepository;

    @Override
    public LoanResponseDto getLoanDetails(String loanAccountNumber) {

        LoanApiResponseDto apiResponse = loanApiClient.fetchLoanDetails(loanAccountNumber);

        LoanAccount loanAccount = new LoanAccount();

        loanAccount.setLoanAccountNumber(apiResponse.getLoanAccountNumber());
        loanAccount.setDueDate(apiResponse.getDueDate());
        loanAccount.setEmiAmount(apiResponse.getEmiAmount());

        loanRepository.save(loanAccount);

        LoanResponseDto responseDto = new LoanResponseDto();

        responseDto.setLoanAccountNumber(loanAccount.getLoanAccountNumber());
        responseDto.setDueDate(loanAccount.getDueDate());
        responseDto.setEmiAmount(loanAccount.getEmiAmount());

        return responseDto;
    }

}
