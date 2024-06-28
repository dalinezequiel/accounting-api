package com.api.bank.accounting.controller;

import com.api.bank.accounting.model.domain.UserModel;
import com.api.bank.accounting.model.dto.user.LoginDto;
import com.api.bank.accounting.model.dto.user.SignUpDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user")
public class UserController {

    //private AuthenticationManager authenticationManager;

    /*@GetMapping
    public UserModel login(@RequestBody @Valid LoginDto loginDto) {
        return null;
    }

    @PostMapping
    public UserModel signUp(@RequestBody @Valid SignUpDto signUpDto) {
        return null;
    }

    @PostMapping
    public UserModel update(@RequestBody @Valid SignUpDto signUpDto) {
        return null;
    }*/
}
