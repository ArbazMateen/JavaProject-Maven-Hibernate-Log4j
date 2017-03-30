package com.thkf.dao;

import com.thkf.dao.interfaces.IDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractDao<A, ID extends Serializable> implements IDao<A, ID> {

    private Class<A> persistenceClass;
    private Session session;

    @SuppressWarnings("unchecked")
    public AbstractDao(Session session) {
        this.persistenceClass = (Class<A>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.session = session;
    }

    public Class<A> getPersistenceClass() {
        return persistenceClass;
    }

    protected Session getSession() {
        if (session == null) {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
        }
        return session;

    }

    @Override
    public A findByID(ID id) {
        return getSession().load(this.getPersistenceClass(), id);
    }

    @Override
    public List<A> getAll() {
        return this.findByCriteria();
    }

    @SuppressWarnings("unchecked")
    private List findByCriteria(Criterion...criteria) {
//        Criteria criteria1 = this.getSession().getCriteriaBuilder().createQuery(this.getPersistenceClass());
        Criteria criteria1 = this.getSession().createCriteria(this.getPersistenceClass());

        for (Criterion c : criteria) {
            criteria1.add(c);
        }
        return (List<A>) criteria1.list();
    }

    @Override
    public A save(A entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void delete(A entity) {
        this.getSession().delete(entity);
    }

    @Override
    public void flush() {
        getSession().flush();
    }

    @Override
    public void clear() {
        getSession().clear();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
