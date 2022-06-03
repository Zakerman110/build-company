package com.solvd.buildcompany.infrastructure;

import com.solvd.buildcompany.dao.impl.GarageDAO;
import com.solvd.buildcompany.dao.impl.OfficeDAO;
import com.solvd.buildcompany.dao.impl.VehicleDAO;
import com.solvd.buildcompany.entity.Garage;
import com.solvd.buildcompany.entity.Office;
import com.solvd.buildcompany.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    OfficeDAO officeDAO;
    @Autowired
    GarageDAO garageDAO;
    @Autowired
    VehicleDAO vehicleDAO;

    @Override
    public void run(String... args) throws Exception {
        seedOffices();
        seedGarages();
        seedVehicles();
    }

    private void seedOffices() {
        if (officeDAO.count() == 0) {
            System.out.println("Seeding offices...");
            Office office1 = new Office("Chernivtsi", "Holovna 228", "0502451167",
                    "chernivtsi@topbud.com", null, null, null, null);
            Office office2 = new Office("Lviv", "Medova 10", "0951183540",
                    "lviv@topbud.com", null, null, null, null);
            officeDAO.saveEntity(office1);
            officeDAO.saveEntity(office2);
            System.out.println("Seeded office count:" + officeDAO.count());
        }
    }

    private void seedGarages() {
        if (garageDAO.count() == 0) {
            System.out.println("Seeding garages...");
            Garage garage1 = new Garage("Holovna 215", officeDAO.getEntityById(1), null);
            Garage garage2 = new Garage("Stepana Bandery 13", officeDAO.getEntityById(2), null);
            garageDAO.saveEntity(garage1);
            garageDAO.saveEntity(garage2);
            System.out.println("Seeded garage count:" + garageDAO.count());
        }
    }

    private void seedVehicles() {
        if (vehicleDAO.count() == 0) {
            System.out.println("Seeding vehicles...");
            Vehicle vehicle1 = new Vehicle("Audi", 2009, "CE1490BK", "Brown",
                    garageDAO.getEntityById(1));
            Vehicle vehicle2 = new Vehicle("Volvo", 2011, "CE1009KC", "Red",
                    garageDAO.getEntityById(1));
            Vehicle vehicle3 = new Vehicle("BMW", 2014, "CE4990BA", "White",
                    garageDAO.getEntityById(2));
            Vehicle vehicle4 = new Vehicle("Mercedes-Benz", 2015, "CE5500BT", "Black",
                    garageDAO.getEntityById(2));
            vehicleDAO.saveEntity(vehicle1);
            vehicleDAO.saveEntity(vehicle2);
            vehicleDAO.saveEntity(vehicle3);
            vehicleDAO.saveEntity(vehicle4);
            System.out.println("Seeded vehicle count:" + vehicleDAO.count());
        }
    }
}
