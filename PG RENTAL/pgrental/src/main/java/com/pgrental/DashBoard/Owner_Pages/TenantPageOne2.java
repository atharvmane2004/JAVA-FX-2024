package com.pgrental.DashBoard.Owner_Pages;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
// import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TenantPageOne2 extends Application {

    Label welcome = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1500);

        // Create a background image
         Image imageTenant = new Image("file:/images/colorbg.png", 1500, 1000, false, false);
         BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false,
                 false, false);
         BackgroundImage backgroundImage = new BackgroundImage(imageTenant, BackgroundRepeat.NO_REPEAT,
                 BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
         Background background = new Background(backgroundImage);

        // SEARCH ICON IMAGE
        Image searchIcon = new Image("file:/images/search2.png", 1500, 1000, false, false);

        // Create a Pane and set the background
        Pane root = new Pane();
       // root.setStyle("-fx-background-color:YELLOW");
        root.setBackground(background);

        // Create ImageView for tenant
        Image imageOfTenant = new Image("file:/images/tenet3.png");
        ImageView imageOfTenantView = new ImageView(imageOfTenant);
        imageOfTenantView.setFitHeight(150);
        imageOfTenantView.setFitWidth(150);
        imageOfTenantView.setLayoutX(20);
        imageOfTenantView.setLayoutY(25);

        // Create welcome label
        welcome = new Label("WELCOME + TENANT_NAME");
        welcome.setFont(Font.font("Maiandra GD", FontWeight.NORMAL, 35));
        welcome.setLayoutX(200); // Adjust layoutX as needed
        welcome.setLayoutY(80); // Adjust layoutY as needed

        // SEARCH BUTTON
        // Image searchIcon = new
        // Image(getClass().getResourceAsStream("/images/searchIcon.png"));
        ImageView searchIconnView = new ImageView(searchIcon);
        searchIconnView.setFitHeight(20);
        searchIconnView.setFitWidth(20);

        Button searchButton = new Button();
        searchButton.setGraphic(searchIconnView);
        searchButton.setLayoutX(500); // Adjust layoutX as needed
        searchButton.setLayoutY(500);
        searchButton.setPrefSize(50, 40);
        searchButton.setStyle(
                "-fx-background-radius: 2em;" 
                     );
        
        // LOCATION TEXTFIELD

        TextField locationTextField = new TextField("Enter the Location");
        locationTextField.setFont(Font.font("Maiandra GD", FontWeight.NORMAL, 20));
        locationTextField.setAlignment(Pos.CENTER);

        locationTextField.setBackground(null);
        ((Node) locationTextField).setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 1100px; " +
                        "-fx-min-height: 40px; " +
                        "-fx-max-width: 1100px; " +
                        "-fx-max-height: 40px;");
        locationTextField.setLayoutX(500);
        // LOCATION HBOX
        HBox locationHbox = new HBox(locationTextField, searchButton);
        locationHbox.setStyle("-fx-background-color:YELLOW");
        locationHbox.setLayoutX(150);
        locationHbox.setLayoutY(200);

        // Add nodes to the root Pane
        root.getChildren().addAll(imageOfTenantView, welcome, locationHbox);

        // Create a scene with the root pane
        Scene scene = new Scene(root, 1500, 1000);
       
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}