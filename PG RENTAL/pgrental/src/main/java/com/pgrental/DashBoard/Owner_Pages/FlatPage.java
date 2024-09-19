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

import com.pgrental.DashBoard.controller.FormNavigationApp;
import com.pgrental.Services.ImageUploader;
import java.io.File;

public class FlatPage {

    private FormNavigationApp app;
    private Pane root;

    public FlatPage(FormNavigationApp app) {
        this.app = app;
        initialize();
    }

    public void initialize() {
        // Image imageHome = new Image("file:src\\main\\resources\\images\\owner1.png", 1500, 1000, false, false);
        // BackgroundSize backgroundSize = new BackgroundSize(
        //         BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        // BackgroundImage backgroundImage = new BackgroundImage(
        //         imageHome, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
        //         backgroundSize);
        // Background background = new Background(backgroundImage);

        root = new Pane();
        // root.setBackground(background);
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

        //TitlePane
        TitledPane pageroot = new TitledPane();
        pageroot.setAlignment(Pos.TOP_RIGHT);

        //GridPane
        GridPane flat = new GridPane();
        flat.setPadding(new Insets(10));

        //Owner Name
        Label OwnerName = new Label("Owner Name :");
        OwnerName.setFont(Font.font(null,FontWeight.BOLD,20));
        TextField ownerField = new TextField();
        HBox OwnerBox = new HBox(45, OwnerName, ownerField);


        //City 
        Label city = new Label("City :");
        city.setFont(Font.font(null,FontWeight.BOLD,20));
        TextField cityField = new TextField();
        HBox cityBox = new HBox(90, city, cityField);


        //Building/Project/Society Name
        Label buildingName = new Label("Building/Project/\nSociety Name :");
        buildingName.setFont(Font.font(null,FontWeight.BOLD,20));
        TextField building = new TextField();
        HBox buildingBox = new HBox(28, buildingName, building);

        //Address 
        Label address = new Label("Address :");
        address.setFont(Font.font(null,FontWeight.BOLD,20));
        TextField addressField = new TextField();
        HBox addressBox = new HBox(65, address, addressField);

        //BHK 
        Label bhk = new Label("BHK :");
        bhk.setFont(Font.font(null,FontWeight.BOLD,20));
        TextField bhkField = new TextField();
        HBox bhkBox = new HBox(85, bhk, bhkField);

        //Rent 
        Label rent = new Label("Rent :");
        rent.setFont(Font.font(null,FontWeight.BOLD,20));
        TextField rentField = new TextField();
        HBox rentBox = new HBox(65, rent, rentField);

        //Available Date From 
        Label date = new Label("Available From :");
        date.setFont(Font.font(null,FontWeight.BOLD,20));
        TilePane r = new TilePane(); 
        DatePicker d = new DatePicker();                        // create a date picker 
        r.getChildren().add(d);                                 // add button and label 
        HBox dateBox = new HBox(30, date, r);

        //Deposit 
        Label deposit = new Label("Deposit :");
        deposit.setFont(Font.font(null,FontWeight.BOLD,20));
        TextField depositField = new TextField();
        HBox depositBox = new HBox(70, deposit, depositField);

        //Photo 
        Label photo = new Label("Photo :");
        photo.setFont(Font.font(null,FontWeight.BOLD,20));
        // TextField photoField = new TextField();
        
        ImageView imageView = new ImageView();
        Button uploadButton = new Button("Choose and Upload Image");

        // Set up the file chooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        // Set up the button action
        // uploadButton.setOnAction(event -> {
        //     File selectedFile = fileChooser.showOpenDialog(primaryStage);
        //     if (selectedFile != null) {
        //         String imageUrl = ImageUploader.uploadImage(selectedFile.getPath(),
        //                 selectedFile.getName());
        //         if (imageUrl != null) {
        //             System.out.println(imageUrl);
        //             Image image = new Image(imageUrl);
        //             imageView.setImage(image);
        //         }
        //     }
        // });
        HBox photoBox = new HBox(78, photo, uploadButton,imageView);
        
        //VBox for Labels, Fields & HBox
        VBox vbHBox = new VBox(30, OwnerBox, cityBox, buildingBox, addressBox, bhkBox, rentBox, dateBox, depositBox, photoBox);

        VBox vb = new VBox(vbHBox);
        vb.setAlignment(Pos.CENTER);
        // vb.setStyle("-fx-padding:10" +
        //     "-fx-background-color: #FF0000" +  
        //     "-fx-border-style: solid inside" +
        //         "-fx-border-width: 5" +
        //        "-fx-border-height: 100" + 
        //         "-fx-border-radius: 5");
        vb.setLayoutX(300);
        vb.setLayoutY(200);
   
        vb.setPadding(new Insets(20));
        
        flat.add(vb, 1, 1);
        pageroot.setContent(vb);
        pageroot.setText("Flat");
        pageroot.setFont(Font.font(null,FontWeight.BOLD,15));
        pageroot.setAlignment(Pos.CENTER);
        pageroot.setExpanded(true);
        
        HBox flatBox = new HBox(pageroot);
        flatBox.setLayoutX(100);
        flatBox.setLayoutY(200);

        Button Back = new Button("Back");
        Back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                app.navigateToHostelPage();
            }
        });

        root.getChildren().addAll(imageOfOwner, welcome, flatBox, Back);
        
        // Group group = new Group(root);

        // Scene sc = new Scene(group);
        // primaryStage.setScene(sc);
        // primaryStage.setWidth(1500);
        // primaryStage.setHeight(1000);
        // primaryStage.setResizable(true);
        // primaryStage.show();
    }

    public Pane getView() {

        return root;

    }
}