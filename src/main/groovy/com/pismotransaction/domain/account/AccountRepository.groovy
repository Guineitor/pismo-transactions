package com.pismotransaction.domain.account

import org.springframework.data.repository.CrudRepository

interface AccountRepository extends CrudRepository<Account, Long> {
}