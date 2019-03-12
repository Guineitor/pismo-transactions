package com.transactions.domain.transaction

class Payment {
     Long accountId
     BigDecimal amount

    Payment(Long accountId, BigDecimal amount) {
        this.accountId = accountId
        this.amount = amount
    }


}
