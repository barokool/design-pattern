package com.student.services.impl;

import com.student.dtos.AccountDto;
import com.student.entities.Account;
import com.student.repositories.AccountRepository;
import com.student.services.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.student.exceptions.NotFoundException;



@Service
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    private Account setAccount(AccountDto dto, Account account) {
        account.setName(dto.getName().trim());
        account.setGender(dto.getGender().trim());
        account.setDateOfBirth(dto.getDateOfBirth());
        account.setEmail(dto.getEmail().trim());
        account.setPassword(dto.getPassword().trim());

        accountRepository.save(account);
        return account;
    }
    private Account getAccountById(String id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Sinh viên có id %s không tồn tại", id)));
    }
    @Override
    public AccountDto getAccount(String id) {
        Account account = getAccountById(id);
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto createAccount(AccountDto dto) {
        Account account = new Account();
        setAccount(dto, account);
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto updateAccount(String id, AccountDto dto) {
        Account account = getAccountById(id);
        setAccount(dto, account);
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto deleteAccount(String id) {
        Account account = getAccountById(id);
        accountRepository.delete(account);
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public Page<AccountDto> getListAccount(Pageable pageable) {
        return accountRepository.findAll(pageable).map(account -> modelMapper.map(account, AccountDto.class));
    }
}


