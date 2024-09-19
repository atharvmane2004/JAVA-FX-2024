package com.pgrental.DashBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.pgrental.dao.hostelDao;
import com.pgrental.dataAccess.LoginPage;
import com.pgrental.dataAccess.OwnerHome;
import com.pgrental.dao.hostelDao;
import com.pgrental.firebase_connection.DataService;

import model.hostelDetail;
import model.hostelDetail;

/**
 * Controller class to manage hostel-related operations.
 */
public class hostelController {
    private String hostel_UniqueID = null;

    LoginPage OwnerLogin = new LoginPage();
    String OwnerName = OwnerLogin.statusOwner;
    private hostelDao HostelDao = new hostelDao(); // Instanceof hostelDao to interact with the database

    public List<hostelDetail> gethostelData() {
        try {
            return HostelDao.getDataList("Hostel");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // private DataService hostelDao = new DataService();
    /**
     * Method to authenticate a hostel based on hostelname and
     * password.
     * 
     * @param hostelname The hostelname of the hostel.
     * @param password  The password of the hostel.
     * @return true if the authentication is successful, false
     *         otherwise.
     */
    public boolean getHostelData(String hostelOwnerName) {
        try {
            hostelDetail hostel = hostelDao.getData("Hostel", hostelOwnerName); // Retrieve hostel details from the database

        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return false; // Return false if authentication fails or an exception occurs
    }


    public boolean addHostelData(hostelDetail HostelData) {
        hostel_UniqueID = LoginPage.statusOwner+": "+ HostelData.getHostelName();
        System.out.println(HostelData);
        try {
            // hostelDao.addData("Hostel", LoginPage.statusOwner, HostelData); // Add player to the "player" collection

            hostelDao.addData("Hostel", hostel_UniqueID, HostelData); // Add player to the "player" collection

            return true; // Return true if the player is added successfully

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return false; // Return false if an exception occurs
    }
}