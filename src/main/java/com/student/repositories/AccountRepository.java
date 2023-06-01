package com.student.repositories;


import com.student.entities.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends MongoRepository<Account,String> {
    @Query(value = "{'email': ?0}")
    Optional<Account> getAcount(String email);

    @Query(value = "{'Email': ?0}", exists = true)
    boolean kiemTraEmail(String Email);

}

