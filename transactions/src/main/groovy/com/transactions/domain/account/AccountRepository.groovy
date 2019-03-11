package com.transactions.domain.account

import org.springframework.data.repository.CrudRepository

interface AccountRepository extends CrudRepository<Account, Long> {
}