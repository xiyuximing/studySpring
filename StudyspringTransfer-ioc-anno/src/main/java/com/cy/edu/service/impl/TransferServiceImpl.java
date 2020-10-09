package com.cy.edu.service.impl;

import com.cy.edu.dao.AccountDao;
import com.cy.edu.pojo.Account;
import com.cy.edu.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author 应癫
 */
@Service("transferService")
public class TransferServiceImpl implements TransferService {


    @Autowired
    private AccountDao accountDao;


    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

/*        try{
            //关闭自动提交事务
            //ConnectionUtils.getInstance().getCurrentThreadConn().setAutoCommit(false);
            TransactionManager.getInstance().beginTransaction();*/
            Account from = accountDao.queryAccountByCardNo(fromCardNo);
            Account to = accountDao.queryAccountByCardNo(toCardNo);

            from.setMoney(from.getMoney()-money);
            to.setMoney(to.getMoney()+money);

            accountDao.updateAccountByCardNo(to);
            accountDao.updateAccountByCardNo(from);
            //提交事务
//            ConnectionUtils.getInstance().getCurrentThreadConn().commit();
/*            TransactionManager.getInstance().commit();
        }catch (Exception e) {
            e.printStackTrace();
            //回滚事务
//            ConnectionUtils.getInstance().getCurrentThreadConn().rollback();
            TransactionManager.getInstance().rollback();
            // 抛出异常便于上层servlet捕获
            throw e;

        }*/




    }
}
