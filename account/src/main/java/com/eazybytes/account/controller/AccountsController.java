package com.eazybytes.account.controller;

import com.eazybytes.account.constant.AccountsConstants;
import com.eazybytes.account.dto.CustomerDto;
import com.eazybytes.account.dto.ResponseDto;
import com.eazybytes.account.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {

    private IAccountsService iAccountsService;
    @PostMapping("create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto body){
        iAccountsService.createAccount(body);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }
}
