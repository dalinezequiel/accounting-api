package com.api.bank.accounting.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class AccountDto {
    @NotNull(message = "The account number cannot be null")
    @Min(value = 9)
    //@Size(min = 9,max = 9, message = "The account number must have 9 digits!")
    private Long number;

    @NotNull(message = "The initial balance cannot be null")
    private double balance;

    private boolean isBlocked;
    @NotNull(message = "The customer id cannot be null")
    private UUID customerId;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
}
