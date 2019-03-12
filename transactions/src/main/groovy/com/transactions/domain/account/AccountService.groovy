package com.transactions.domain.account

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountService {

    @Autowired
    AccountRepository accountRepository

    Account create(BigDecimal creditLimit, BigDecimal withdrawalLimit) {
        accountRepository.save(new Account(creditLimit, withdrawalLimit))
    }

    Account changeLimits(Long id, BigDecimal creditLimit, BigDecimal withdrawalLimit) {
        Account account = accountRepository.findById(id).orElseThrow {new RuntimeException("Account with id: " + id + " not found")}

        account.availableWithdrawalLimit = account.availableWithdrawalLimit.add(withdrawalLimit)
        account.availableCreditLimit = account.availableCreditLimit.add(creditLimit)

        accountRepository.save(account)
    }

    Account findBy(Long id) {
        accountRepository.findById(id).orElseThrow {new RuntimeException("Account with id: " + id + " not found")}
    }

}
