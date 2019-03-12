package com.transactions.domain.transaction

import org.springframework.beans.factory.annotation.Autowired


import com.transactions.domain.OperationsTypes

class TransactionService implements ITransactionService {
    private TransactionRepository transactionRepository;

    @Autowired
    TransactionService(TransactionRepository _transactionRepository) {
        transactionRepository = _transactionRepository
    }

    @Override
    Transaction addTransaction(Long accountId, OperationsTypes operation, BigDecimal amount) {
        return null
    }

    @Override
    List<Transaction> addPayments(List<Payment> payments) {
        return null
    }
}
