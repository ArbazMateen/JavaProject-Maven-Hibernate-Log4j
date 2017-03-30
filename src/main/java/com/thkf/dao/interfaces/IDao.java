package com.thkf.dao.interfaces;

import org.hibernate.Session;

import java.util.List;

public interface IDao<A, ID> {

    A findByID(ID id);
    List<A> getAll();
    A save(A entity);
    void delete(A entity);
    void flush();
    void clear();
    void setSession(Session session);

}
