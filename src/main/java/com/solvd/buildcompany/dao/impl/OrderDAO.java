package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.IOrderDAO;
import com.solvd.buildcompany.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO extends BaseDAO<Order> implements IOrderDAO {

    public OrderDAO() {
        super(Order.class);
    }
}
