package com.student.services;

import com.student.dtos.AccountDto;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface IAccountService_command {
    AccountDto getAccount(String id);

    AccountDto createAccount (AccountDto dto);

    AccountDto updateAccount (String id, AccountDto dto);

    AccountDto deleteAccount (String id);
    Page<AccountDto> getListAccount (Pageable pageable);
}
