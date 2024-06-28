package com.api.bank.accounting.service;

import com.api.bank.accounting.model.domain.AccountModel;
import com.api.bank.accounting.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public AccountModel save(AccountModel accountModel) {
        return accountRepository.save(accountModel);
    }

    public boolean existsByNumber(Long accountNumber) {
        return accountRepository.existsByNumber(accountNumber);
    }

    public Page<AccountModel> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    public Optional<AccountModel> findById(UUID id) {
        return accountRepository.findById(id);
    }

    @Transactional
    public void delete(AccountModel accountModel) {
        accountRepository.delete(accountModel);
    }
}
