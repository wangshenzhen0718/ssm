package com.wang.bank.service.impl;

import com.wang.bank.dao.AccountDao;
import com.wang.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("i2")
public class IsolationService2 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    // 2号
    // 负责insert
    @Transactional(timeout = 10)
    /*表示超过10秒如果该事务中所有的DML语句还没有执行完毕的话，最终结果会选择回滚。
        默认值-1，表示没有时间限制。
        这里有个坑，事务的超时时间指的是哪段时间？
        在当前事务当中，最后一条DML语句执行之前的时间。如果最后一条DML语句后面很有很多业务逻辑，这些业务代码执行的时间不被计入超时时间。*/
    public void save(Account act) {
        // 睡眠一会
        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.insert(act);//最后一条DML语句

    }


}
