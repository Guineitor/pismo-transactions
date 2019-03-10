package com.pismotransaction.domain.account

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage
import com.sun.xml.internal.ws.api.message.Message

import javax.persistence.*

@Entity
@Table(name = "accounts")
class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(nullable = false)
    BigDecimal availableCreditLimit

    @Column(nullable = false)
    BigDecimal availableWithdrawalLimit

    Account(BigDecimal availableCreditLimit, BigDecimal availableWithdrawalLimit) {
        this.availableCreditLimit = availableCreditLimit != null ? availableCreditLimit : new BigDecimal(0)
        this.availableWithdrawalLimit = availableWithdrawalLimit != null ? availableWithdrawalLimit: new BigDecimal(0)
    }

}