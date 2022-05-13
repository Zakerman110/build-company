package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.IOfficeDAO;
import com.solvd.buildcompany.entity.Office;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OfficeDAO extends BaseDAO<Office> implements IOfficeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public OfficeDAO() {
        super(Office.class);
    }

    @Override
    @Transactional
    public List<Office> getOfficesByCity(String city) {

        TypedQuery<Office> query = entityManager.createQuery(
                "SELECT o FROM offices o WHERE o.city LIKE :name" , Office.class);

        return query.setParameter("name", city).getResultList();
    }
}
