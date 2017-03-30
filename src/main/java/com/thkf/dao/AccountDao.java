package com.thkf.dao;

import com.thkf.dao.interfaces.IAccountDao;
import com.thkf.models.Account;
import org.hibernate.Session;

import java.util.List;

public class AccountDao extends AbstractDao<Account, Long> implements IAccountDao {

    public AccountDao(Session session) {
        super(session);
    }

    @Override
    public List<Account> findByTitle(String title) {
        return null;
    }
}
