package com.transactions.domain.transaction

import com.transactions.domain.payment.Payment
import com.transactions.domain.OperationsTypes

interface ITransactionService {

    Transaction addTransaction(Long accountId, OperationsTypes operations, BigDecimal amount);

    List<Transaction> addPayments(List<Payment> payments);
}