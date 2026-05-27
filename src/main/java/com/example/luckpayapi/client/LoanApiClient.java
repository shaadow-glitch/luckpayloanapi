package com.example.luckpayapi.client;

import com.example.luckpayapi.dto.LoanApiResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "loan-client",
        url = "https://demo9993930.mockable.io"
    )
public interface LoanApiClient {
    @GetMapping("/loanaccount/{loanAccountNumber}")
    LoanApiResponseDto fetchLoanDetails( @PathVariable String loanAccountNumber);
}

//package com.example.luckpayapi.client;
//
//import com.example.luckpayapi.dto.LoanApiResponseDto;
//import org.springframework.stereotype.Component;
//
//@Component
//public class LoanApiClient {
//
//    public LoanApiResponseDto fetchLoanDetails() {
//
//        LoanApiResponseDto response =
//                new LoanApiResponseDto();
//
//        response.setLoanAccountNumber("123456");
//        response.setDueDate("2023-06-15");
//        response.setEmiAmount(2500);
//
//        return response;
//    }
//}

