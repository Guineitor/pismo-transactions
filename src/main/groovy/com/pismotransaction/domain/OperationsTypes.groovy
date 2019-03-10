package com.pismotransaction.domain

enum OperationsTypes {
    CASH_PURCHASE("COMPRA A VISTA", 2),
    INSTALLMENT_PURCHASE("COMPRA PARCELADA", 1),
    WITHDRAWAL("SAQUE", 0),
    PAYMENT("PAGAMENTO", 0)


    OperationsTypes(String description, Integer chargeOrder) {
        this.description = description
        this.chargeOrder = chargeOrder
    }

    private String description
    private Integer chargeOrder


}