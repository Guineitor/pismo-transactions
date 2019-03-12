package com.pismo.transactions.domain

enum OperationsTypes {
    CASH_PURCHASE(2, 'PURCHASE IN '),
    INSTALLMENT_PURCHASE(1, 'PURCHASE IN INSTALLMENT'),
    WITHDRAWAL(0, 'SAQUE'),
    PAYMENT(0, 'PAGAMENTO')

    Integer chargeOrder
    String desc

    OperationsTypes(Integer chargeOrder, String desc) {
        this.chargeOrder = chargeOrder
        this.desc = desc
    }

}