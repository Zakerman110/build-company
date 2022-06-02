package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.ISpecialtyDAO;
import com.solvd.buildcompany.entity.Specialty;
import org.springframework.stereotype.Repository;

@Repository
public class SpecialtyDAO extends BaseDAO<Specialty> implements ISpecialtyDAO {

    public SpecialtyDAO() {
        super(Specialty.class);
    }
}
