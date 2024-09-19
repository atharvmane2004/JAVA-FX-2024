package com.pgrental.DashBoard.Owner_Pages;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.pgrental.Services.ImageUploader;
import java.io.File;

public class Dues extends Application {

    // private FormNavigationApp app;
    private Pane root;

    // public FlatPage(FormNavigationApp app) {
    //     this.app = app;
    //     initialize();
    // }

    public void start(Stage primaryStage) throws Exception {
        Image imageHome = new Image("file:src\\main\\resources\\images\\ownerbg.jpg",
        1500, 1000, false, false);
        BackgroundSize backgroundSize = new BackgroundSize(
        BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(
        imageHome, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
        backgroundSize);
        Background background = new Background(backgroundImage);

        root = new Pane();
        root.setBackground(background);
        root.setPrefSize(1500, 1000);

        Image ImageOfOwner = new Image("file:src\\main\\resources\\images\\owner1.png");
        ImageView imageOfOwner = new ImageView(ImageOfOwner);
        imageOfOwner.setFitHeight(150);
        imageOfOwner.setFitWidth(150);
        imageOfOwner.setLayoutX(20);
        imageOfOwner.setLayoutY(25);

        Label welcome = new Label("WELCOME + OWNER_NAME");
        welcome.setFont(Font.font("Maiandra GD", FontWeight.NORMAL, 35));
        welcome.setLayoutX(200);
        welcome.setLayoutY(80);
        

        Button Back = new Button("Back");
        Back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // app.navigateToHostelPage();
            }
        });

        //Dues VBox
       

        Label duration = new Label("Duration :");
        duration.setFont(Font.font(null, FontWeight.BOLD, 20));
        VBox durationBox = new VBox(duration);
        durationBox.setPadding(new Insets(10));
        durationBox.setStyle("-fx-background-radius: 1em; "+
        "-fx-background-color: #fff;");
        //durationBox.setMaxWidth(50);

        Label amount = new Label("₹37,500");
        amount.setTextFill(Color.ORANGE);
        amount.setFont(Font.font(null, FontWeight.BOLD, 20));
        Label TotalDuesLabel = new Label("Total Dues");
        TotalDuesLabel.setFont(Font.font(null, FontWeight.BOLD, 20));
        VBox TotalDues = new VBox(amount, TotalDuesLabel);
        TotalDues.setStyle("-fx-background-radius: 1em; "+
        "-fx-background-color: #fff;");
        TotalDues.setPadding(new Insets(5));
        TotalDues.setLayoutX(250);
        TotalDues.setLayoutY(400);
        
        Label tenantsCount = new Label("14");
        tenantsCount.setFont(Font.font(null, FontWeight.BOLD, 20));
        Label TotalTenants = new  Label("Total Tenants");
        TotalTenants.setFont(Font.font(null, FontWeight.BOLD, 20));
        VBox Total_Tenants = new VBox(tenantsCount, TotalTenants);
        Total_Tenants.setStyle("-fx-background-radius: 1em; "+
        "-fx-background-color: #fff;");
        Total_Tenants.setPadding(new Insets(5));
 
        HBox Due_Tenants = new HBox(10, TotalDues, Total_Tenants);
        Due_Tenants.setPadding(new Insets(3));

        VBox DuesBox = new VBox(durationBox, Due_Tenants);
        DuesBox.setStyle("-fx-background-radius: 1em; "+
        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5,0,0,0);"+
        "-fx-background-color: #D3D3D3;");
        DuesBox.setPadding(new Insets(5));
        DuesBox.setMaxWidth(1000);
        DuesBox.setMaxHeight(1000);
        DuesBox.setAlignment(Pos.CENTER);
        DuesBox.setLayoutX(200);
        DuesBox.setLayoutY(400);

    
        root.getChildren().addAll(imageOfOwner, welcome, DuesBox, Back);
        
        Group group = new Group(root);

        Scene sc = new Scene(group);
        primaryStage.setScene(sc);
        primaryStage.setWidth(1500);
        primaryStage.setHeight(1000);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public Pane getView() {

        return root;

    }
}