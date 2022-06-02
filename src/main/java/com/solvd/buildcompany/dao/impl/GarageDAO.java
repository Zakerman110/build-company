package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.IGarageDAO;
import com.solvd.buildcompany.entity.Garage;
import org.springframework.stereotype.Repository;

@Repository
public class GarageDAO extends BaseDAO<Garage> implements IGarageDAO {

    public GarageDAO() {
        super(Garage.class);
    }
}
