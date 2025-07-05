package com.sun.accounts.repository;

import com.sun.accounts.entity.Accounts;
import com.sun.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
}
