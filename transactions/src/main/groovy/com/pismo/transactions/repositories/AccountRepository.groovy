package com.pismo.transactions.repositories

import com.pismo.transactions.domain.account.Account
import org.springframework.data.repository.CrudRepository

interface AccountRepository extends CrudRepository<Account, Long>{

}