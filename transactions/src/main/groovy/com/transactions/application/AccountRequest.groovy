package com.transactions.application

class AccountRequest {
    CreditLimit availableCreditLimit
    WithdrawLimit availableWithdrawalLimit

    AccountRequest(CreditLimit availableCreditLimit, WithdrawLimit availableWithdrawalLimit) {
        this.availableCreditLimit = availableCreditLimit
        this.availableWithdrawalLimit = availableWithdrawalLimit
    }

}
