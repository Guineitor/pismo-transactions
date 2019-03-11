package com.transactions.domain.account

import org.springframework.beans.factory.annotation.Autowired

class AccountService implements IAccountService {

    @Autowired
    AccountRepository _repo

    @Override
    Account create(BigDecimal creditLimit, BigDecimal withdrawalLimit) {
        return new Account(50G, 50G);
    }

    @Override
    Account changeLimits(Long id, BigDecimal creditLimit, BigDecimal withdrawalLimit) {
        return null
    }

    @Override
    Account findBy(Long id) {
        return new Account(50G, 50G);
    }

}
