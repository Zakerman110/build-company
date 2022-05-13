package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.IEmployeeDAO;
import com.solvd.buildcompany.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO extends BaseDAO<Employee> implements IEmployeeDAO {

    public EmployeeDAO() {
        super(Employee.class);
    }
}
