package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.ISupplyDAO;
import com.solvd.buildcompany.entity.Supply;
import org.springframework.stereotype.Repository;

@Repository
public class SupplyDAO extends BaseDAO<Supply> implements ISupplyDAO {

    public SupplyDAO() {
        super(Supply.class);
    }
}
