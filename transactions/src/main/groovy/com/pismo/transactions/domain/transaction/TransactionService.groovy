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

    Transaction addTransaction(Long accountId, OperationsTypes operation, BigDecimal amount) {
        createTransaction( accountId,  operation,  amount)

    }



    Transaction createTransaction(Long accountId, OperationsTypes operation, BigDecimal amount) {
        Date now = new Date()
        Transaction transaction = new Transaction(accountId, operation, amount, amount, now, now)
        transactionRepository.save(transaction)
    }

    List<Transaction> addPayment(List<Payment> payments) {

        ArrayList<Transaction> transactions = new ArrayList<Transaction>()

        for (payment in payments) {

            Transaction paymentoTransac = createTransaction(payment.accountId, OperationsTypes.PAYMENT ,payment.amount)
            transactions.add(paymentoTransac)

            List<Transaction> unpaidTransactions = transactionRepository.listUnpaidTransactionsBy(payment.getAccountId())

            List<Transaction> unpaidTransactionsSorted =  unpaidTransactions.sort{ x, y -> x.operation.chargeOrder <=> y.eventDate}

            for ( unpaid in unpaidTransactionsSorted) {
                BigDecimal balance = unpaid.balance
                balance = balance.add(payment.amount)


                if (balance.signum() <= 0) {
                    unpaid.setBalance(balance);
                    paymentoTransac.setBalance(new BigDecimal(0));
                    break;

                } else {
                    payment.setAmount(balance);

                }

            }

        }
        transactions.toList()
    }


    List<Transaction> findAll(Long accountId) {
        transactionRepository.findAllbyAccount accountId
    }


}
