package com.api.bank.accounting.controller;

import com.api.bank.accounting.mapper.CustomerMapper;
import com.api.bank.accounting.model.dto.CustomerDto;
import com.api.bank.accounting.model.domain.CustomerModel;
import com.api.bank.accounting.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CustomerDto customerDto) {
        var customerModel = CustomerMapper.toSaveCustomerModel(customerDto, customerDto.getAddress(),
                customerDto.getContact());
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerModel));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerModel>> getAll(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") UUID id) {
        Optional<CustomerModel> customerModelOptional = customerService.findById(id);
        if (customerModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(customerModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<CustomerModel> customerModelOptional = customerService.findById(id);
        if (customerModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!");
        }
        customerService.delete(customerModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Customer was deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id,
                                         @RequestBody @Valid CustomerDto customerDto) {
        Optional<CustomerModel> customerModelOptional = customerService.findById(id);
        if (customerModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!");
        }
        var customerModel = CustomerMapper.toUpdateCustomerModel(customerDto, customerDto.getAddress(),
                customerDto.getContact(), customerModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(customerService.save(customerModel));
    }
}
