package com.pismo.transactions.domain.transaction
import com.pismo.transactions.domain.OperationsTypes

import javax.persistence.*

@Entity
@Table(name = "transactions")
class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    Long id

    @Column(nullable = false)
    Long accountId

    @Enumerated(EnumType.ORDINAL)
    OperationsTypes operation

    @Column(nullable = false)
    BigDecimal amount

    @Column(nullable = false)
    BigDecimal balance

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Date eventDate

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Date dueDate

    protected Transaction(){}

    Transaction(Long accountId, OperationsTypes operation, BigDecimal amount, BigDecimal balance, Date eventDate, Date dueDate) {
        this.accountId = accountId
        this.operation = operation
        this.amount = amount
        this.balance = balance
        this.eventDate = eventDate
        this.dueDate = dueDate
    }

}