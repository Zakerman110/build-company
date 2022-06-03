package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.IBaseDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class BaseDAO<T> implements IBaseDAO<T> {

    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> type;

    public BaseDAO(Class<T> type) {
        super();
        this.type = type;
    }

    @Override
    public List<T> getEntities() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(type);
        Root<T> root = cq.from(type);
        cq.select(root);
        return this.entityManager.createQuery(cq).getResultList();
    }

    @Override
    public T getEntityById(int id) {
        return entityManager.find(type, id);
    }

    @Override
    @Transactional
    public void saveEntity(T entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void updateEntity(T entity) {
        entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void deleteEntity(T entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public long count() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(type)));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
