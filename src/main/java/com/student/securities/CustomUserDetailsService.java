package com.student.securities;

import com.student.entities.Account;
import com.student.repositories.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public CustomUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public JwtUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.getAcount(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Tài khoản có email %s không tồn tại", email)));
        return getUserDetails(account);
    }

    private JwtUserDetails getUserDetails(Account account) {
        return new JwtUserDetails(
                account.getName(),
                account.getEmail(),
                account.getPassword(),
                account.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()),
                account.isTrangThai()
        );
    }
}
