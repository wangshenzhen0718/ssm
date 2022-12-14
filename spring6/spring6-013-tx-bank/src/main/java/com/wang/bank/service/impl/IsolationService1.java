package com.wang.bank.service.impl;

import com.wang.bank.dao.AccountDao;
import com.wang.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("i1")
public class IsolationService1 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    // 1号
    // 负责查询
    // 当前事务可以读取到别的事务没有提交的数据。
    //@Transactional(isolation = Isolation.READ_UNCOMMITTED)
    // 对方事务提交之后的数据我才能读取到。
    @Transactional(isolation = Isolation.READ_UNCOMMITTED, readOnly = true)
    /*将当前事务设置为只读事务，在该事务执行过程中只允许select语句执行，delete insert update均不可执行。
        该特性的作用是：启动spring的优化策略。提高select语句执行效率。
        如果该事务中确实没有增删改操作，建议设置为只读事务。*/
    public void getByActno(String actno) {
        Account account = accountDao.selectByActno(actno);
        System.out.println("查询到的账户信息：" + account);
    }

}