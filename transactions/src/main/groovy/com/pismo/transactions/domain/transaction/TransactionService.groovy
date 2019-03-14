package com.pismo.transactions.domain.transaction

import com.pismo.transactions.domain.OperationsTypes
import com.pismo.transactions.domain.account.AccountService
import com.pismo.transactions.domain.payment.Payment
import com.pismo.transactions.repositories.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.List;

@Service
class TransactionService {

    @Autowired
    TransactionRepository transactionRepository

    @Autowired
    AccountService accountService


    Transaction addTransaction(Long accountId, OperationsTypes operation, BigDecimal amount) {

        BigDecimal originalAmount = amount;
        List<Transaction> positiveTransactions = transactionRepository.listPositiveTransactionBy(accountId);

        positiveTransactions.each { positiv ->
            if (positiv.getBalance().compareTo(amount) > 0) {
                BigDecimal newBalance = positiv.getBalance().subtract(amount)
                positiv.balance = newBalance
                amount = new BigDecimal(0);
            } else {
                amount = amount.subtract(positiv.balance)
                positiv.balance = new BigDecimal(0)
            }

        }


        amount = amount.negate();

        Transaction transaction =  createTransaction(accountId, operation, amount)
        changeAvailableCredit(accountId, operation , amount)
        transaction

    }


    Transaction createTransaction(Long accountId, OperationsTypes operation, BigDecimal amount) {
        Date now = new Date()
        Transaction transaction = new Transaction(accountId, operation, amount, amount, now, now)
        transactionRepository.save(transaction)
    }

    List<Transaction> addPayment(List<Payment> payments) {

        ArrayList<Transaction> transactions = new ArrayList<Transaction>()

        for (payment in payments) {

            Transaction paymentoTransac = createTransaction(payment.accountId, OperationsTypes.PAYMENT, payment.amount)
            transactions.add(paymentoTransac)

            List<Transaction> unpaidTransactions = transactionRepository.listUnpaidTransactionsBy(payment.getAccountId())

            List<Transaction> unpaidTransactionsSorted = unpaidTransactions.sort { x -> x.operation.chargeOrder}
            unpaidTransactionsSorted = unpaidTransactionsSorted.sort { y -> y.eventDate}
            BigDecimal diffConvered = new BigDecimal(0)
            for (unpaid in unpaidTransactionsSorted) {

                BigDecimal balance = unpaid.balance
                balance = balance.add(payment.amount)

                if (balance.signum() <= 0) {
                    unpaid.setBalance balance
                    changeAvailableCredit(payment.accountId,  unpaid.operation, payment.amount)
                    paymentoTransac.setBalance(new BigDecimal(0))
                    break

                } else {
                    payment.setAmount balance
                    changeAvailableCredit(payment.accountId, unpaid.operation, unpaid.balance.negate())
                    paymentoTransac.setBalance balance
                    unpaid.balance = new BigDecimal(0)

                }
            }
        }
        transactions.toList()
    }


    List<Transaction> findAll(Long accountId) {
        transactionRepository.findAllbyAccount accountId
    }


    private changeAvailableCredit(Long accountId, OperationsTypes operation, BigDecimal amount) {
        if (operation.equals(OperationsTypes.CASH_PURCHASE) || operation.equals(OperationsTypes.INSTALLMENT_PURCHASE)) {
            accountService.changeLimits(accountId, amount, new BigDecimal(0));
        } else {
            accountService.changeLimits(accountId, new BigDecimal(0), amount);
        }

    }
}