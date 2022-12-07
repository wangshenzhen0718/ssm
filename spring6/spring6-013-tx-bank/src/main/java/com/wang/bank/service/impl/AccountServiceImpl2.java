package com.wang.bank.service.impl;

import com.wang.bank.dao.AccountDao;
import com.wang.bank.pojo.Account;
import com.wang.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService2")
public class AccountServiceImpl2 implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(String fromActno, String toActno, double money) {

    }

    @Transactional
    public void withdraw() {
        System.out.println("取款");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(Account account) {
        accountDao.insert(account);
        String s=null;
        s.toString();
    }
}