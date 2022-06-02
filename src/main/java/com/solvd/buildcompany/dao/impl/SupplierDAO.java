package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.ISupplierDAO;
import com.solvd.buildcompany.entity.Supplier;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierDAO extends BaseDAO<Supplier> implements ISupplierDAO {

    public SupplierDAO() {
        super(Supplier.class);
    }
}
