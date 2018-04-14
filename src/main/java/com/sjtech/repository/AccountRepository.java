package com.sjtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjtech.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
