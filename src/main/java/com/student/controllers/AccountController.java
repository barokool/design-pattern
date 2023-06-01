package com.student.controllers;


import com.student.services.impl.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.student.dtos.AccountDto;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable String id) {
        return new ResponseEntity<>(accountService.getAccount(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<AccountDto>> getList(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<AccountDto> accountPage = accountService.getListAccount(pageable);
        return new ResponseEntity<>(accountPage, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<AccountDto> create(@Valid @RequestBody AccountDto dto) {
        return new ResponseEntity<>(accountService.createAccount(dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> update(@PathVariable String id, @Valid @RequestBody AccountDto dto) {
        return new ResponseEntity<>(accountService.updateAccount(id, dto), HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDto> delete(@PathVariable String id) {
        return new ResponseEntity<>(accountService.deleteAccount(id), HttpStatus.OK);
    }
}
