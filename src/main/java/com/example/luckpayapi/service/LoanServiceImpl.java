package com.example.luckpayapi.service;

import com.example.luckpayapi.client.LoanApiClient;
import com.example.luckpayapi.dto.LoanApiResponseDto;
import com.example.luckpayapi.dto.LoanResponseDto;
import com.example.luckpayapi.entity.LoanAccount;
import com.example.luckpayapi.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanServiceImpl implements LoanService{

    private final LoanApiClient loanApiClient;
    private final LoanRepository loanRepository;

    @Override
    public LoanResponseDto getLoanDetails(String loanAccountNumber) {
        log.info("Fetching loan details for account number: {}",
                loanAccountNumber);
        LoanApiResponseDto apiResponse = loanApiClient.fetchLoanDetails(loanAccountNumber);

        log.info("Received response from integration layer");
        LoanAccount loanAccount = new LoanAccount();

        loanAccount.setLoanAccountNumber(apiResponse.getLoanAccountNumber());
        loanAccount.setDueDate(apiResponse.getDueDate());
        loanAccount.setEmiAmount(apiResponse.getEmiAmount());

        log.info("Saving loan details into database");
        loanRepository.save(loanAccount);

        log.info("Loan details saved successfully");
        LoanResponseDto responseDto = new LoanResponseDto();

        responseDto.setLoanAccountNumber(loanAccount.getLoanAccountNumber());
        responseDto.setDueDate(loanAccount.getDueDate());
        responseDto.setEmiAmount(loanAccount.getEmiAmount());

        return responseDto;
    }

}
