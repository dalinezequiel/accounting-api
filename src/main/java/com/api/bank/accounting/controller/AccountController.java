package com.api.bank.accounting.controller;

import com.api.bank.accounting.model.dto.AccountDto;
import com.api.bank.accounting.model.domain.AccountModel;
import com.api.bank.accounting.model.domain.CustomerModel;
import com.api.bank.accounting.service.AccountService;
import com.api.bank.accounting.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/account")
public class AccountController {
    final AccountService accountService;
    final CustomerService customerService;

    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AccountDto accountDto) {
            if (accountService.existsByNumber(accountDto.getNumber())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLICT: Account number is already exist!");
            }

            Optional<CustomerModel> customerModelOptional = customerService.findById(accountDto.getCustomerId());
            if (customerModelOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CONFLICT: Customer not found!");
            }

            var accountModel = new AccountModel();
            BeanUtils.copyProperties(accountDto, accountModel);

            var customerModel = new CustomerModel();
            customerModel.setId(accountDto.getCustomerId());

            accountModel.setCustomer(customerModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(accountModel));
    }

    @GetMapping
    public ResponseEntity<Page<AccountModel>> getAll(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") UUID id) {
        Optional<AccountModel> accountModelOptional = accountService.findById(id);
        if (!accountModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<AccountModel> accountModelOptional = accountService.findById(id);
        if (!accountModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found!");
        }
        accountService.delete(accountModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Account was deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id,
                                         @RequestBody @Valid AccountDto accountDto) {
        Optional<AccountModel> accountModelOptional = accountService.findById(id);
        if (!accountModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found!");
        }

        Optional<CustomerModel> customerModelOptional = customerService.findById(accountDto.getCustomerId());
        if (!customerModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!");
        }

        var accountModel = new AccountModel();
        BeanUtils.copyProperties(accountDto, accountModel);
        accountModel.setId(accountModelOptional.get().getId());
        accountModel.setCreatedAt(accountModelOptional.get().getCreatedAt());
        accountModel.setUpdateAt(LocalDateTime.now());

        // MY ADDITIONAL CODE
        var customer = new CustomerModel();
        customer.setId(accountDto.getCustomerId());
        accountModel.setCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body(accountService.save(accountModel));
    }
}
