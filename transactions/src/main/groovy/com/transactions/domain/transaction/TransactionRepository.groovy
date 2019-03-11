package com.transactions.domain.transaction

import com.transactions.domain.transaction.Transaction
import org.springframework.data.repository.CrudRepository


interface TransactionRepository extends CrudRepository<Transaction, Long> {
}

