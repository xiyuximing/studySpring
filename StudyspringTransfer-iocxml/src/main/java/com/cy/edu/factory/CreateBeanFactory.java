package com.cy.edu.factory;

import com.cy.edu.utils.ConnectionUtils;

/**
 * Created by Yang on 2020/10/8.
 */
public class CreateBeanFactory {

    public static ConnectionUtils getInstanceStatic() {
        return new ConnectionUtils();
    }

    public ConnectionUtils getInstance() {
        return new ConnectionUtils();
    }
}
