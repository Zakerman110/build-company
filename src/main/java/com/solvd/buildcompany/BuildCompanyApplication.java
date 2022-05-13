package com.solvd.buildcompany;

import com.solvd.buildcompany.dao.impl.OfficeDAO;
import com.solvd.buildcompany.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class BuildCompanyApplication {

    @Autowired
    public OfficeDAO officeDAO;

    public static void main(String[] args) {
        SpringApplication.run(BuildCompanyApplication.class, args);
    }

    @PostConstruct
    public void init() {

        //testDAO();
    }

    public void testDAO() {

        // Testing saveEntity
        Office office = new Office();

        office.setCity("Chernivtsi");
        office.setAddress("Holovna 113");
        office.setPhone("0501801190");
        office.setEmail("topbud@gmail.com");

        officeDAO.saveEntity(office);

        // Testing getOfficesByCity
        try {
            List<Office> offices = officeDAO.getOfficesByCity("Chernivtsi");

            for (var item:
                    offices) {
                System.out.println(item.toString());
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }

        // Testing getEntityById
        try {
            Office office1 = officeDAO.getEntityById(1);
            System.out.println(office1.toString());
        } catch(Exception e) {
            System.out.println(e.toString());
        }

        // Testing updateEntity
        Office updatedOffice = new Office();

        updatedOffice.setId(2);
        updatedOffice.setCity("Chernivtsi");
        updatedOffice.setAddress("Holovna 25");
        updatedOffice.setPhone("0501801190");
        updatedOffice.setEmail("topbud@gmail.com");

        officeDAO.updateEntity(updatedOffice);

        // Testing deleteEntity
        Office delOffice = new Office();

        delOffice.setId(2);

        officeDAO.deleteEntity(delOffice);

        // Testing getEntities
        try {
            List<Office> offices = officeDAO.getEntities();
            System.out.println(offices.toString());
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }

}
