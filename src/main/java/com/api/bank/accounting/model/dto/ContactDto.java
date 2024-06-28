package com.api.bank.accounting.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactDto {

    @NotBlank(message = "The phone prefix cannot be blank")
    @Size(min = 3, max = 3, message = "The phone prefix length is 3 digits")
    private String phonePrefix;

    @NotBlank(message = "The phone number cannot be blank")
    @Size(min = 9, max = 9, message = "The phone number length is 9 digits")
    private String phoneNumber;

    @NotBlank(message = "The email cannot be blank")
    //@Email(message = "The email is invalid",regexp = "@")
    private String email;

    public String getPhonePrefix() {
        return phonePrefix;
    }

    public void setPhonePrefix(String phonePrefix) {
        this.phonePrefix = phonePrefix;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
