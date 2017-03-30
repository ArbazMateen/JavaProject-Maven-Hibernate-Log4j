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
//        conf.addResource("hibernate.cfg.xml");
//        conf.setProperty("hibernate.connection.driver_class", "org.apache.derby.jdbc.EmbeddedDriver");
        String homeFolder = FIleManager.HOME_FOLDER;
        conf.setProperty("hibernate.connection.url", "jdbc:derby:"+homeFolder+"/AccountsDB/accounts;create=true");
//        conf.setProperty("hibernate.connection.username", "");
//        conf.setProperty("hibernate.connection.password", "");
//        conf.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect");
//        conf.addAnnotatedClass(com.thkf.models.Account.class);
//        return conf.buildSessionFactory(new StandardServiceRegistryBuilder()
//                .applySettings(conf.getProperties()).build());
//        return new Configuration().configure().buildSessionFactory();
        return conf.buildSessionFactory();
    }


}
