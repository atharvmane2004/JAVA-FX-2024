package com.pgrental.DashBoard.Owner_Pages;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class OwnerOne extends Application {
    public void start(Stage primaryStage) {
        Image imageHome = new Image("file:src\\main\\resources\\images\\colorbg.jpg", 1500, 1000, false, false);
        BackgroundSize backgroundSize = new BackgroundSize(
                BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(
                imageHome, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        Background background = new Background(backgroundImage);

        Pane root = new Pane();
        root.setBackground(background);
        root.setPrefSize(1500, 1000);

        Image ImageOfOwner = new Image("file:pgrental\\src\\main\\resources\\images\\Owner.jpg");
        ImageView imageOfOwner = new ImageView(ImageOfOwner);
        imageOfOwner.setFitHeight(150);
        imageOfOwner.setFitWidth(150);
        imageOfOwner.setLayoutX(20);
        imageOfOwner.setLayoutY(25);

        Label welcome = new Label("WELCOME + OWNER_NAME");
        welcome.setFont(Font.font("Maiandra GD", FontWeight.NORMAL, 35));
        welcome.setLayoutX(200);
        welcome.setLayoutY(80);

        Button button = new Button("+");
        button.setTextFill(Color.BLACK);
        button.setLayoutX(200);
        button.setLayoutY(50);
        button.setFont(new Font(50));

        Label location = new Label("Location : ");
        location.setFont(new Font(25));

        TextField locationField = new TextField();
        locationField.setStyle("-fx-set-pref-width:50");
        locationField.setStyle("fx-background-radius:15;" +
                "-fx-border-radius:15;" +
                "-fx-padding:5 10;" +
                "-fx-background-color:white;" +
                "-fx-border-color:blue;" +
                "-fx-border-width:1;");

        Label Price = new Label("Price : ");
        Price.setFont(new Font(25));

        TextField priceField = new TextField();
        priceField.setStyle("-fx-set-pref-width:50");
        priceField.setStyle("fx-background-radius:15;" +
                "-fx-border-radius:15;" +
                "-fx-padding:5 ;" +
                "-fx-background-color:white;" +
                "-fx-border-color:blue;" +
                "-fx-border-width:1;");

        Label Amenities = new Label("Amenties : ");
        Amenities.setFont(new Font(25));

        TextField AmenitiesField = new TextField();
        AmenitiesField.setStyle("-fx-set-pref-width:50");
        AmenitiesField.setStyle("fx-background-radius:15;" +
                "-fx-border-radius:15;" +
                "-fx-padding:5 10;" +
                "-fx-background-color:white;" +
                "-fx-border-color:blue;" +
                "-fx-border-width:1;");

        Label Status = new Label("Status : ");
        Status.setFont(new Font(25));

        TextField StatusField = new TextField();
        StatusField.setStyle("-fx-set-pref-width:50");
        StatusField.setStyle("fx-background-radius:15;" +
                "-fx-border-radius:15;" +
                "-fx-padding:5 10;" +
                "-fx-background-color:white;" +
                "-fx-border-color:blue;" +
                "-fx-border-width:1;");

        VBox lables = new VBox(50, location, Price, Amenities, Status);
        lables.setBlendMode(BlendMode.COLOR_BURN);
        lables.setLayoutX(500);
        lables.setLayoutY(500);

        VBox textfields = new VBox(55, locationField, priceField, AmenitiesField, StatusField);
        textfields.setBlendMode(BlendMode.COLOR_BURN);
        textfields.setLayoutX(500);
        textfields.setLayoutY(500);

        HBox hb = new HBox(20, lables, textfields);
        hb.setBlendMode(BlendMode.COLOR_BURN);
        hb.setLayoutX(500);
        hb.setLayoutY(500);

        VBox vb5 = new VBox(25, button, hb);
        vb5.setLayoutX(500);
        vb5.setLayoutY(300);

        root.getChildren().addAll(imageOfOwner, welcome, vb5);

        Group group = new Group(root);

        Scene sc = new Scene(group);
        primaryStage.setScene(sc);
        primaryStage.setWidth(1500);
        primaryStage.setHeight(1000);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

}