package com.pgrental.DashBoard.Owner_Pages;

import javafx.scene.Group;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SignupPage extends Application {

    public void start(Stage primaryStage) {

        // Image imageV = new Image(getClass().getResourceAsStream("/images/home2.jpeg"));
        // BackgroundSize backgroundSize = new BackgroundSize(
        //         BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        // BackgroundImage backgroundImage = new BackgroundImage(imageV, BackgroundRepeat.NO_REPEAT,
        //         BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        // Background background = new Background(backgroundImage);

        // Signup Label
        Label Signup = new Label("Welcome");
        Signup.setFont(Font.font("Arial Black", FontWeight.BOLD, 30));

        // Create Account Label
        Label createAcc = new Label("Create Your Account");
        createAcc.setFont(Font.font(null, FontWeight.SEMI_BOLD, 25));

        // Name
        Label name = new Label("Name : ");
        name.setFont(Font.font(null, FontWeight.SEMI_BOLD, 20));

        TextField nameField = new TextField();
        nameField.setStyle("-fx-set-pref-width:50");
        nameField.setStyle(
                "-fx-background-radius: 15; " +
                        "-fx-border-radius: 15; " +
                        "-fx-padding: 5 10; " +
                        "-fx-background-color: white; " +
                        "-fx-border-color: blue; " +
                        "-fx-border-width: 1;");

        // Email
        Label email = new Label("Email : ");
        email.setFont(Font.font(null, FontWeight.SEMI_BOLD, 20));

        TextField emailField = new TextField();
        emailField.setPrefWidth(50);
        emailField.setStyle(
                "-fx-background-radius: 15; " +
                        "-fx-border-radius: 15; " +
                        "-fx-padding: 5 10; " +
                        "-fx-background-color: white; " +
                        "-fx-border-color: blue; " +
                        "-fx-border-width: 1;");

        // Password
        Label password = new Label("Password : ");
        password.setFont(Font.font(null, FontWeight.SEMI_BOLD, 20));

        PasswordField passwordField = new PasswordField();
        passwordField.setStyle(
                "-fx-background-radius: 15; " +
                        "-fx-border-radius: 15; " +
                        "-fx-padding: 5 10; " +
                        "-fx-background-color: white; " +
                        "-fx-border-color: blue; " +
                        "-fx-border-width: 1;");

        // Confirm Password
        Label confirm = new Label("Confirm Password : ");
        confirm.setFont(Font.font(null, FontWeight.SEMI_BOLD, 20));

        PasswordField confirmField = new PasswordField();
        confirmField.setStyle(
                "-fx-background-radius: 15; " +
                        "-fx-border-radius: 15; " +
                        "-fx-padding: 5 10; " +
                        "-fx-background-color: white; " +
                        "-fx-border-color: blue; " +
                        "-fx-border-width: 1;");

        // Already have Account ?
        Label loginAcc = new Label("Already have Account ? ");
        loginAcc.setFont(Font.font(null, FontWeight.SEMI_BOLD, 25));

        Button login = new Button("Login");
        login.setTextFill(Color.SADDLEBROWN);
        login.setStyle("-fx-background-color: BLUE;" + "-fx-text-fill: white; " + "-fx-background-radius: 15;");
        login.setFont(new Font(15));;

        // VBox
        VBox fieldBox1 = new VBox(10, name, nameField);
        fieldBox1.setMaxSize(300, 30);

        VBox fieldBox2 = new VBox(10, email, emailField);
        fieldBox2.setMaxSize(300, 30);

        VBox fieldBox3 = new VBox(10, password, passwordField);
        fieldBox3.setMaxSize(300, 30);

        VBox fieldBox4 = new VBox(10, confirm, confirmField);
        fieldBox1.setMaxSize(300, 30);

        VBox vb = new VBox(40, Signup, createAcc, fieldBox1, fieldBox2, fieldBox3, fieldBox4);
        vb.setAlignment(Pos.TOP_CENTER);

        // Signup Button
        Button signupButton = new Button("Signup");
        signupButton.setTextFill(Color.BLUE);
        signupButton.setFont(new Font(20));
        signupButton.setStyle("-fx-background-radius: 15;");

        // OR Label
        Label OR = new Label("OR");
        OR.setAlignment(Pos.CENTER);
        OR.setFont(new Font(20));
        OR.setTextFill(Color.BLACK);

        // HBox
        HBox LoginBox = new HBox(10, loginAcc, login);
        LoginBox.setAlignment(Pos.CENTER);

        VBox vb1 = new VBox(40, vb, signupButton, OR, LoginBox);
        vb1.setAlignment(Pos.CENTER);
        // vb1.setBackground(background);
        vb1.setStyle("-fx-padding: 100 0 100 950");
        //vb1.setPrefWidth(900);

        VBox vb2 = new VBox();
        vb2.setStyle("-fx-background-color: BLUE;");
        
        HBox hb = new HBox(vb2,vb1);
        
        Scene scene = new Scene(hb, 1500, 1000);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
}