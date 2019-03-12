package com.transactions.application

import com.transactions.domain.account.CreditLimit
import com.transactions.domain.account.WithdrawLimit

class AccountRequest {

    CreditLimit availableCreditLimit
    WithdrawLimit availableWithdrawalLimit
}