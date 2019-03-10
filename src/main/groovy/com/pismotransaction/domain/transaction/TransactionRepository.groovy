package com.pismotransaction.domain.transaction

import com.pismotransaction.domain.transaction.Transaction
import org.springframework.data.repository.CrudRepository;


interface TransactionRepository extends CrudRepository<Transaction, Long> {

}

