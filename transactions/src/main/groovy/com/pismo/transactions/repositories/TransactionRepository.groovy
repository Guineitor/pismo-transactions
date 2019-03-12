package com.pismo.transactions.repositories

import com.pismo.transactions.domain.transaction.Transaction
import org.springframework.data.repository.CrudRepository

interface TransactionRepository extends CrudRepository<Transaction, Long>{

}