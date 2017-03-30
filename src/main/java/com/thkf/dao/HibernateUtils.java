package com.thkf.dao;

import com.thkf.managers.FIleManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        Configuration conf = new Configuration();
        conf.configure();
        String homeFolder = FIleManager.HOME_FOLDER;
        conf.setProperty("hibernate.connection.url", "jdbc:derby:" + homeFolder + "/AccountsDB/accounts;create=true");
        return conf.buildSessionFactory();
    }


}
