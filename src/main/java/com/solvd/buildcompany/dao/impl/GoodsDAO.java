package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.IGoodsDAO;
import com.solvd.buildcompany.entity.Goods;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDAO extends BaseDAO<Goods> implements IGoodsDAO {

    public GoodsDAO() {
        super(Goods.class);
    }
}
