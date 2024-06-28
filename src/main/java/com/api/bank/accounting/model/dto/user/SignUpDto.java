package com.api.bank.accounting.model.dto.user;

import jakarta.validation.constraints.NotBlank;

public class SignUpDto {

    @NotBlank(message = "The username cannot be blank!")
    private String username;

    @NotBlank(message = "The password cannot be blank")
    private String password;

    @NotBlank(message = "The email cannot be blank")
    private String email;

    public @NotBlank(message = "The username cannot be blank!") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "The username cannot be blank!") String username) {
        this.username = username;
    }

    public @NotBlank(message = "The password cannot be blank") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "The password cannot be blank") String password) {
        this.password = password;
    }

    public @NotBlank(message = "The email cannot be blank") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "The email cannot be blank") String email) {
        this.email = email;
    }
}
