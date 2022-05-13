package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.IVehicleDAO;
import com.solvd.buildcompany.entity.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleDAO extends BaseDAO<Vehicle> implements IVehicleDAO {

    public VehicleDAO() {
        super(Vehicle.class);
    }
}
