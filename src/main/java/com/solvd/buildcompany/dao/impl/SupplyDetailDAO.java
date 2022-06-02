package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.ISupplyDetailDAO;
import com.solvd.buildcompany.entity.SupplyDetail;
import org.springframework.stereotype.Repository;

@Repository
public class SupplyDetailDAO extends BaseDAO<SupplyDetail> implements ISupplyDetailDAO {

    public SupplyDetailDAO() {
        super(SupplyDetail.class);
    }
}
