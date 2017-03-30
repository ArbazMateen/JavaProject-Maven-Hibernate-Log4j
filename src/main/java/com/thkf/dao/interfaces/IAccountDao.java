package com.thkf.dao.interfaces;

import com.thkf.models.Account;

import java.util.List;

public interface IAccountDao extends IDao<Account, Long> {

    List<Account> findByTitle(String title);

}
