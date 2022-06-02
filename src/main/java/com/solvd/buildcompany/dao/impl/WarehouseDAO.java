package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.IWarehouseDAO;
import com.solvd.buildcompany.entity.Warehouse;
import org.springframework.stereotype.Repository;

@Repository
public class WarehouseDAO extends BaseDAO<Warehouse> implements IWarehouseDAO {

    public WarehouseDAO() {
        super(Warehouse.class);
    }
}
