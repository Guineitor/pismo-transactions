package com.transactions.domain.account


class AccountService implements IAccountService {

    @Override
    Account create(BigDecimal creditLimit, BigDecimal withdrawalLimit) {
        return null
    }

    @Override
    Account changeLimits(Long id, BigDecimal creditLimit, BigDecimal withdrawalLimit) {
        return null
    }

    @Override
    List<Account> findAll() {
        return null
    }

    @Override
    Account findBy(Long id) {
        return null
    }
}
