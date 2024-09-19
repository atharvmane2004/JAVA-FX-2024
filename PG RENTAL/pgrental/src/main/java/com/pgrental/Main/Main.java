package com.pgrental.Main;


import com.pgrental.DashBoard.Owner_Pages.Dues;
import com.pgrental.dataAccess.LoginPage;
import com.pgrental.dataAccess.NotificationView;
import com.pgrental.dataAccess.SignupPage;
import com.pgrental.dataAccess.homePage;

import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Application.launch(homePage.class,args);
    }
}