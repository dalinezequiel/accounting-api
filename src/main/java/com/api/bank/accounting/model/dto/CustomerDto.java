package com.api.bank.accounting.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CustomerDto {
    @NotNull(message = "The name cannot be null")
    private String name;

    @NotNull(message = "The surname cannot be null")
    private String surname;

    @NotNull(message = "The birthday date cannot be null")
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    //@Pattern(regexp = "dd/MM/yyyy")
    private LocalDate birthday;

    @Valid
    private AddressDto address;

    @Valid
    private ContactDto contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public ContactDto getContact() {
        return contact;
    }

    public void setContact(ContactDto contact) {
        this.contact = contact;
    }
}
