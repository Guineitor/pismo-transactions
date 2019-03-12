package com.pismo.transactions.application

import com.pismo.transactions.domain.account.Account
import com.pismo.transactions.domain.account.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController {

    @Autowired
    AccountService accountService

    @GetMapping("/v1/accounts/{id}")
    Account findOne(@PathVariable Long id) {
        accountService.findBy(id)
    }

    @PostMapping("/v1/accounts")
    Account save(@RequestBody AccountRequest params) {
        accountService.create(params.availableCreditLimit?.amount, params.availableWithdrawalLimit?.amount)
    }

    @PatchMapping("/v1/accounts/{id}")
    Account update(@PathVariable Long id, @RequestBody AccountRequest params) {
        accountService.changeLimits(id, params.availableCreditLimit?.amount, params.availableWithdrawalLimit?.amount)
    }

}
