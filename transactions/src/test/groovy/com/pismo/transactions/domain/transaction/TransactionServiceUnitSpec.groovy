package com.pismo.transactions.domain.transaction

import com.pismo.transactions.domain.OperationsTypes
import com.pismo.transactions.repositories.TransactionRepository
import spock.lang.Specification
class TransactionServiceUnitSpec extends Specification {

    TransactionRepository transactionRepository = Mock(TransactionRepository)
    TransactionService transactionService = Spy(TransactionService)
    Date now = new Date()

    def setup() {
        transactionService.transactionRepository = transactionRepository
    }


    def "Should save a new transaction"() {
        given:
        Long accountId = new Long(1)
        OperationsTypes operation = OperationsTypes.CASH_PURCHASE
        BigDecimal amount = -500
        BigDecimal balance = -500
        Date eventDate = now
        Date dueDate = now


        when:
        Transaction expectedTransaction = transactionService.createTransaction(
                accountId,  operation,  amount
        )

        then:
        1 * transactionRepository.save(_ as Transaction)>> new Transaction(id: 1, accountId: accountId, operation: operation, amount: amount)
        expectedTransaction.accountId == accountId
        expectedTransaction.operation == operation
        expectedTransaction.amount == amount

    }
}
