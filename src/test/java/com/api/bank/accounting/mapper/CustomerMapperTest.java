package com.api.bank.accounting.mapper;

import com.api.bank.accounting.model.dto.CustomerDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {
    private CustomerMapper customerMapper;

    @BeforeEach
    void setUp() {
        customerMapper = new CustomerMapper();
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each");
    }

    @Test
    void shouldMapCustomerDTOToCustomerModel() {
        CustomerDto customerDto = new CustomerDto();
    }
}