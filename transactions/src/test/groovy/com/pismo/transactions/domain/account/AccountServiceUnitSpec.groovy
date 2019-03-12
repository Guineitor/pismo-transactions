package com.pismo.transactions.domain.account

import com.pismo.transactions.repositories.AccountRepository
import spock.lang.Specification

class AccountServiceUnitSpec extends Specification {

    AccountRepository accountRepository = Mock(AccountRepository)
    AccountService accountService = Spy(AccountService)

    def setup() {
        accountService.accountRepository = accountRepository
    }

    def 'Should save a new account'() {
        given:
        BigDecimal creditLimit = 100
        BigDecimal withdrawalLimit = 50

        when:
        Account expectedAccount = accountService.create(creditLimit, withdrawalLimit)

        then:
        1 * accountRepository.save(_ as Account)>> new Account(id: 1, availableCreditLimit: creditLimit, availableWithdrawalLimit: withdrawalLimit)
        expectedAccount.availableCreditLimit == creditLimit
        expectedAccount.availableWithdrawalLimit == withdrawalLimit
    }

    def 'Should update account limits'() {
        given:
        Account actualAccount = new Account(id: 1, availableCreditLimit: 100, availableWithdrawalLimit: 50)

        when:
        Account result = accountService.changeLimits(actualAccount.id, new BigDecimal(-10), new BigDecimal(10))

        then:
        1 * accountRepository.findById(actualAccount.id) >> Optional.of(actualAccount)
        1 * accountRepository.save(actualAccount) >> actualAccount
        result.availableCreditLimit == new BigDecimal(90)
        result.availableWithdrawalLimit == new BigDecimal(60)
    }

    def 'Should find an account by id'() {
        given:
        Account actualAccount = new Account(id: 1, availableCreditLimit: 100, availableWithdrawalLimit: 50)

        when:
        Account result = accountService.findBy(actualAccount.id)

        then:
        1 * accountRepository.findById(actualAccount.id) >> Optional.of(actualAccount)
        result.availableCreditLimit == new BigDecimal(100)
        result.availableWithdrawalLimit == new BigDecimal(50)
    }

}
