package com.wang.bank.dao;

import com.wang.bank.pojo.Account;

public interface AccountDao {

    Account selectById(Long id);

    int updateAccount(Account account);
    //int insertAccount(Account account);
}
