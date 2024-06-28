package com.api.bank.accounting.repository;

import com.api.bank.accounting.model.domain.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AccountRepository extends JpaRepository<AccountModel, UUID> {
    boolean existsByNumber(Long number);
}
