package com.pismo.transactions.domain.transaction

import com.pismo.transactions.domain.OperationsTypes
import com.pismo.transactions.repositories.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionService {

    @Autowired
    TransactionRepository transactionRepository

    Transaction createTransaction(Long accountId, OperationsTypes operation, BigDecimal amount) {
        Date now = new Date()
        Transaction transaction = new Transaction(accountId, operation, amount, amount, now, now)
        transactionRepository.save(transaction)
    }

}
