package com.thkf;

import com.thkf.dao.AccountDao;
import com.thkf.dao.HibernateUtils;
import com.thkf.dao.interfaces.IAccountDao;
import com.thkf.models.Account;
import com.thkf.models.LoginWith;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Session session = HibernateUtils.getSessionFactory().openSession();
//        session.beginTransaction();

        IAccountDao dao = new AccountDao(session);
//        dao.setSession(session);

        Account a = new Account("ArbazMateen", "Mateen@123");
        a.setLoginWith(LoginWith.GOOGLE);

        Transaction tx = session.beginTransaction();

        dao.save(a);

        tx.commit();

//        session.save(a);

//        session.getTransaction().commit();
        session.close();
        HibernateUtils.getSessionFactory().close();

        Parent root = FXMLLoader.load(getClass().getResource("/views/mainScreen.fxml"));
        primaryStage.setTitle("Accounts");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
