package com.student.factories.impl;

import com.student.dtos.AccountDto;
import com.student.entities.Account;
import com.student.factories.CreateEntity;

/**
 * @author : Viet Van Lau
 * @project design-pattern
 * @created 03/06/2023 - 4:28 PM
 */
public class AccountImpl implements CreateEntity<Account, AccountDto> {
    @Override
    public Account create(AccountDto dto) {
        System.out.println("AccountImpl");
            return new Account.AccountBuilder().setName(dto.getName().trim()).setGender(dto.getGender().trim()).setDateOfBirth(dto.getDateOfBirth()).setEmail(dto.getEmail().trim()).setPassword(dto.getPassword().trim()).build();
    }
}
