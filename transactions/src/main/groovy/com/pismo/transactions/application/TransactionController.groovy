package com.pismo.transactions.application

import com.pismo.transactions.domain.transaction.Transaction
import com.pismo.transactions.domain.transaction.TransactionService
import com.pismo.transactions.application.request.TransactionRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionController {

    @Autowired
    TransactionService transactionService

    @PostMapping("/v1/transactions")
    Transaction save(@RequestBody TransactionRequest params) {
        transactionService.createTransaction(
                params?.accountId, params?.operation, params?.amount
        )
    }


}
