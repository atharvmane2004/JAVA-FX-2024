package com.pgrental.DashBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.pgrental.dao.flatDao;
import com.pgrental.dataAccess.LoginPage;
import com.pgrental.dataAccess.OwnerHome;
import com.pgrental.dao.flatDao;
import com.pgrental.firebase_connection.DataService;

import model.flatDetail;
import model.flatDetail;

/**
 * Controller class to manage flat-related operations.
 */
public class flatController {
    private String flat_UniqueID = null;

    LoginPage OwnerLogin = new LoginPage();
    String OwnerName = OwnerLogin.statusOwner;
    private flatDao flatDao = new flatDao(); // Instanceof flatDao to interact with the database

    public List<flatDetail> getflatData() {
        try {
            return flatDao.getDataList("Flat");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // private DataService flatDao = new DataService();
    /**
     * Method to authenticate a flat based on flatname and
     * password.
     * 
     * @param flatname The flatname of the flat.
     * @param password The password of the flat.
     * @return true if the authentication is successful, false
     *         otherwise.
     */
    public boolean getflatData(String flatOwnerName) {
        try {
            flatDetail flat = flatDao.getData("Flat", flatOwnerName); // Retrieve flat details from the database

        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return false; // Return false if authentication fails or an exception occurs
    }

    public boolean addflatData(flatDetail flatData) {
        flat_UniqueID = LoginPage.statusOwner + ": " + flatData.getFlatOwner();
        System.out.println(flatData);
        try {
            // flatDao.addData("Flat", OwnerLogin.statusOwner+, flatData); // Add player to
            // the "player" collection
            flatDao.addData("Flat", flat_UniqueID, flatData); // Add player to the "player" collection

            return true; // Return true if the player is added successfully

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return false; // Return false if an exception occurs
    }

    /**
     * Method to handle flat signup.
     * 
     * @param flatname The flatname of the new flat.
     * @param password The password of the new flat.
     * @return true if the signup is successful, false otherwise.
     */
    // public boolean handleSignup(String flatname, String password) {
    // try {
    // // Create a map to store flat details
    // Map<String, Object> data = new HashMap<>();
    // data.put("password", password); // Add password to the map

    // data.put("flatName", flatname); // Add flatname to the map

    // data.put("role", "flat"); // Add flat role to the map
    // flatDao.addData("flat", flatname, data); // Add flat details to the database

    // System.out.println("flat registered successfully");

    // // Print success message

    // return true; // Return true if signup is successful
    // } catch (Exception ex) {
    // ex.printStackTrace(); // Print stack trace for debugging

    // return false; // Return false if an exception occurs
    // }
    // }

    /**
     * Method to get flat details based on flatname.
     * 
     * @param flatname The flatname of the flat.
     * @return flatDetail object containing flat details, or null
     *         if an exception occurs.
     */
    public flatDetail getflatDetail(String flatname) {
        try {
            return flatDao.getData("flat", flatname); // Retrieve flat details from the database
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return null; // Return null if an exception occurs
    }
}