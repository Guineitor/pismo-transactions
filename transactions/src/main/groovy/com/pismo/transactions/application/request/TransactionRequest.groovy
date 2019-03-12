package com.pismo.transactions.application.request

import com.pismo.transactions.domain.OperationsTypes

class TransactionRequest {
    Long accountId;
    OperationsTypes operation;
    BigDecimal amount;

    public TransactionParameters(Long accountId, OperationsTypes operation, BigDecimal amount) {
        this.accountId = accountId;
        this.operation = operation;
        this.amount = amount;
    }
}
