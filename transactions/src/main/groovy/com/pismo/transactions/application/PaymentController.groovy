package com.pismo.transactions.application

import com.pismo.transactions.domain.payment.Payment
import com.pismo.transactions.domain.transaction.TransactionService
import com.pismo.transactions.domain.transaction.Transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class PaymentController {

    @Autowired
    TransactionService transactionService


    @PostMapping("/v1/payments")
    List<Transaction> CreatePayment(@RequestBody List<Payment > list ) {
        transactionService.CreatePayment(list)
    }
}
