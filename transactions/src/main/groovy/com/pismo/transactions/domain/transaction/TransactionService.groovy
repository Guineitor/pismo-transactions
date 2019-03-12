package com.pismo.transactions.domain.transaction

import com.pismo.transactions.domain.OperationsTypes
import com.pismo.transactions.domain.payment.Payment
import com.pismo.transactions.repositories.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.List;

@Service
class TransactionService {

    @Autowired
    TransactionRepository transactionRepository

    Transaction createTransaction(Long accountId, OperationsTypes operation, BigDecimal amount) {
        Date now = new Date()
        Transaction transaction = new Transaction(accountId, operation, amount, amount, now, now)
        transactionRepository.save(transaction)
    }

    List<Transaction> CreatePayment(List<Payment> payments) {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>()

        for (payment in payments) {
            transactions.add(createTransaction(payment.accountId, OperationsTypes.PAYMENT ,payment.amount))
        }
        transactions.toList()
    }
}
