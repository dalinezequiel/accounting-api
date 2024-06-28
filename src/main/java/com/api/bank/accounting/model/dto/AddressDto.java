package com.api.bank.accounting.model.dto;

import jakarta.validation.constraints.NotNull;

public class AddressDto {
    @NotNull(message = "The street name cannot be null")
    private String street;
    private String neighborhood;
    private int streetNumber;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}
