package com.cy.edu.service.impl;

import com.cy.edu.dao.AccountDao;
import com.cy.edu.pojo.Account;
import com.cy.edu.service.TransferService;

/**
 * @author 应癫
 */
public class TransferServiceImpl implements TransferService {

//    private AccountDao accountDao = new JdbcAccountDaoImpl();
    /**
     * 改成工厂调用
     */
//    private AccountDao accountDao = (AccountDao)BeanFactory.getBean("accountDao");

    private AccountDao accountDao;

    //通过构造函数或set传值


    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

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
