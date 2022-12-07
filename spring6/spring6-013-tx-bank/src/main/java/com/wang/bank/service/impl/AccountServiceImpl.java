package com.wang.bank.service.impl;

import com.wang.bank.dao.AccountDao;
import com.wang.bank.pojo.Account;
import com.wang.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;
    @Resource(name = "accountService2")
    private AccountService accountService;

    @Override
    @Transactional
    public void transfer(String fromActno, String toActno, double money) {
        // 查询账户余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("账户余额不足");
        }
        // 余额充足，开始转账
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        int count = accountDao.update(fromAct);
/*        String s=null;
        s.toString();*/
        count += accountDao.update(toAct);
        if (count != 2) {
            throw new RuntimeException("转账失败，请联系银行");
        }
    }

    @Transactional
    public void withdraw() {
        System.out.println("取款");
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    /*REQUIRED：支持当前事务，如果不存在就新建一个(默认)【没有就新建，有就加入】*/
    public void save(Account account) {
        accountDao.insert(account);

        Account account1 = new Account("act-004",1000.0);
        accountService.save(account1);//上面是REQUIRED  所以加入
    }
}