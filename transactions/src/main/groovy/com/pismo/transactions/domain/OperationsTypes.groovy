package com.pismo.transactions.domain

enum OperationsTypes {
    CASH_PURCHASE(2, 'PAGAMENTO À VISTA  '),
    INSTALLMENT_PURCHASE(1, 'PAGAMENTO PARCELADO'),
    WITHDRAWAL(0, 'SAQUE'),
    PAYMENT(0, 'PAGAMENTO')

    Integer chargeOrder
    String desc


    OperationsTypes(Integer chargeOrder, String desc) {
        this.chargeOrder = chargeOrder
        this.desc = desc
    }

}