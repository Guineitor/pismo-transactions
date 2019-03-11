package com.transactions.application
import com.transactions.domain.account.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@
class AccountController {
    @Autowired
    AccountService accountService


    @GetMapping("/v1/accounts/{id}")
    Account findOne(@PathVariable Long id) {
        accountService.findBy(id)
    }

    @PostMapping("/v1/accounts")
    Account save(@RequestBody AccountRequest params) {
        accountService.create(params.availableCreditLimit, params.availableCreditLimit);
    }


    @PatchMapping("/v1/accounts/{id}")
    Account update(@PathVariable Long id, @RequestBody AccountRequest params) {
        accountService.changeLimits(id, params.availableCreditLimit, params.availableWithdrawalLimit)
    }
}
