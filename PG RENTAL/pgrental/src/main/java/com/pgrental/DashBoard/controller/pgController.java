package com.pgrental.DashBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.pgrental.dao.pgDao;
import com.pgrental.dataAccess.LoginPage;
import com.pgrental.dataAccess.OwnerHome;
import com.pgrental.dao.pgDao;
import com.pgrental.firebase_connection.DataService;

import model.pgDetail;
import model.pgDetail;

/**
 * Controller class to manage pg-related operations.
 */
public class pgController {
    private String PG_UniqueID = null;
    private pgDao pgDao = new pgDao(); // Instanceof pgDao to interact with the database

    public List<pgDetail> getpgData() {
        try {
            return pgDao.getDataList("PG");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // private DataService pgDao = new DataService();
    /**
     * Method to authenticate a pg based on pgname and
     * password.
     * 
     * @param pgname   The pgname of the pg.
     * @param password The password of the pg.
     * @return true if the authentication is successful, false
     *         otherwise.
     */
    public boolean getpgData(String pgOwnerName) {
        try {
            pgDetail pg = pgDao.getData("PG", pgOwnerName); // Retrieve pg details from the database

        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return false; // Return false if authentication fails or an exception occurs
    }

    public boolean addpgData(pgDetail pgData) {
        System.out.println(pgData);
        PG_UniqueID = LoginPage.statusOwner + ": " + pgData.getPgName();
        System.out.println(PG_UniqueID);
        try {
            pgDao.addData("PG", PG_UniqueID, pgData); // Add player to the "player" collection

            return true; // Return true if the player is added successfully

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return false; // Return false if an exception occurs
    }

    /**
     * Method to handle pg signup.
     * 
     * @param pgname   The pgname of the new pg.
     * @param password The password of the new pg.
     * @return true if the signup is successful, false otherwise.
     */
    // public boolean handleSignup(String pgname, String password) {
    // try {
    // // Create a map to store pg details
    // Map<String, Object> data = new HashMap<>();
    // data.put("password", password); // Add password to the map

    // data.put("pgName", pgname); // Add pgname to the map

    // data.put("role", "pg"); // Add pg role to the map
    // pgDao.addData("pg", pgname, data); // Add pg details to the database

    // System.out.println("pg registered successfully");

    // // Print success message

    // return true; // Return true if signup is successful
    // } catch (Exception ex) {
    // ex.printStackTrace(); // Print stack trace for debugging

    // return false; // Return false if an exception occurs
    // }
    // }

    /**
     * Method to get pg details based on pgname.
     * 
     * @param pgname The pgname of the pg.
     * @return pgDetail object containing pg details, or null
     *         if an exception occurs.
     */
    public pgDetail getpgDetail(String pgname) {
        try {
            return pgDao.getData("pg", pgname); // Retrieve pg details from the database
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return null; // Return null if an exception occurs
    }
}