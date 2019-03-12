package com.pismo.transactions.application.request

import com.pismo.transactions.domain.account.CreditLimit
import com.pismo.transactions.domain.account.WithdrawLimit

class AccountRequest {

    CreditLimit availableCreditLimit
    WithdrawLimit availableWithdrawalLimit

}
