package com.transactions.domain.account

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

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