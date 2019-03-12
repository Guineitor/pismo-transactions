package com.pismo.transactions.repositories

import com.pismo.transactions.domain.transaction.Transaction
import com.pismo.transactions.domain.OperationsTypes
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface TransactionRepository extends CrudRepository<Transaction, Long>{

    @Query("SELECT t FROM Transaction t WHERE t.operation <> com.pismo.transactions.domain.OperationsTypes.PAYMENT and t.accountId = :accountId and t.balance < 0")
    List<Transaction> listUnpaidTransactionsBy(@Param("accountId") Long accountId);

    @Query("SELECT t FROM Transaction t WHERE t.operation = com.pismo.transactions.domain.OperationsTypes.PAYMENT and t.accountId = :accountId and t.balance > 0")
    List<Transaction> listPositiveTransactionBy(@Param("accountId") Long accountId);

    @Query("SELECT t FROM Transaction t WHERE t.accountId = :accountId ")
    List<Transaction> findAllbyAccount(@Param("accountId") Long accountId);

}
