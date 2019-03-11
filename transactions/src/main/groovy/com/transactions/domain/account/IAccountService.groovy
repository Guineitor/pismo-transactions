package com.transactions.domain.account

interface IAccountService {
    Account create(BigDecimal creditLimit, BigDecimal withdrawalLimit)

    Account changeLimits(Long id, BigDecimal creditLimit, BigDecimal withdrawalLimit)

    List<Account> findAll()

    Account findBy(Long id)

}