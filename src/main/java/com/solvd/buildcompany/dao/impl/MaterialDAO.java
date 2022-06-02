package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.IMaterialDAO;
import com.solvd.buildcompany.entity.Material;
import org.springframework.stereotype.Repository;

@Repository
public class MaterialDAO extends BaseDAO<Material> implements IMaterialDAO {

    public MaterialDAO() {
        super(Material.class);
    }
}
