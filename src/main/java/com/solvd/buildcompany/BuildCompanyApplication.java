package com.solvd.buildcompany;

import com.solvd.buildcompany.dao.impl.OfficeDAO;
import com.solvd.buildcompany.entity.Office;
import com.solvd.buildcompany.infrastructure.ConnectionPool;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        testConnectionPool();
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

    public void testConnectionPool() {

        ConnectionPool pool = ConnectionPool.getInstance();

        System.out.println("Connection pool size: " + pool.getConnectionPoolSize() +
                " Used connections size: " + pool.getUsedConnectionsSize());

        Connection con = pool.getConnection();

        try (PreparedStatement pr = con.prepareStatement("SELECT * FROM offices");
             ResultSet rs = pr.executeQuery()) {

            System.out.println("SQL result using Connection Pool:");
            System.out.println("Connection pool size: " + pool.getConnectionPoolSize() +
                    " Used connections size: " + pool.getUsedConnectionsSize());

            while (rs.next()) {
                Office office = new Office();
                office.setId(rs.getInt("id"));
                office.setCity(rs.getString("city"));
                office.setAddress(rs.getString("address"));
                office.setPhone(rs.getString("phone"));
                office.setEmail(rs.getString("email"));

                System.out.println(office.toString());
            }

        } catch (SQLException e) {
            System.out.println("Test connection pool error.");
            System.out.println(e.toString());
        } finally {
            pool.releaseConnection(con);
        }
        System.out.println("Connection pool size: " + pool.getConnectionPoolSize() +
                " Used connections size: " + pool.getUsedConnectionsSize());
    }

}
