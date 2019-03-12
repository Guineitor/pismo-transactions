package com.pismo.transactions.domain.transaction

import com.pismo.transactions.domain.OperationsTypes
import com.pismo.transactions.repositories.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionService {

    @Autowired
    TransactionRepository transactionRepository

    Transaction create(Long accountId, OperationsTypes operation, BigDecimal amount, BigDecimal balance, Date eventDate, Date dueDate){
        transactionRepository.save(
            new Transaction(
                accountId,  operation,  amount,  balance,  eventDate,  dueDate
            ))
    }

}
