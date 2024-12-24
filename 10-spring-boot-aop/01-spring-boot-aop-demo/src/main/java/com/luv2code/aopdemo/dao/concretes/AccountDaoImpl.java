package com.luv2code.aopdemo.dao.concretes;

import com.luv2code.aopdemo.dao.abstracts.AccountDAO;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING DB WORK: ADDING AN ACCOUNT");
    }
}
