package com.cy.edu.factory;

import com.cy.edu.utils.TransactionManager;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Yang on 2020/10/6.
 */
public class ProxyFactory {

/*    private ProxyFactory(){

    }

    private static final ProxyFactory instance = new ProxyFactory();

    public static ProxyFactory getInstance() {
        return instance;
    }*/

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public Object getJdkProxy(Object o) {
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), ((proxy, method, args) -> {
            Object result = null;
            try {
                transactionManager.beginTransaction();
                method.invoke(o, args);
                transactionManager.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transactionManager.rollback();
                throw e;
            }
            return result;
        }));
    }

    public Object getCGLibProxy(Object o) {
        return Enhancer.create(o.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                try {
                    transactionManager.beginTransaction();
                    method.invoke(o, objects);
                    transactionManager.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    transactionManager.rollback();
                    throw e;
                }
                return result;
            }
        });
    }
}
