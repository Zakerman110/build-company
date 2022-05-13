package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.IMaterialUsageDAO;
import com.solvd.buildcompany.entity.MaterialUsage;
import org.springframework.stereotype.Repository;

@Repository
public class MaterialUsageDAO extends BaseDAO<MaterialUsage> implements IMaterialUsageDAO {

    public MaterialUsageDAO() {
        super(MaterialUsage.class);
    }
}
