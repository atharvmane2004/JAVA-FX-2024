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
import javafx.scene.control.TextArea;
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

// public class HostelPage {

//     private FormNavigationApp app;
//     private Pane root;

//     public HostelPage(FormNavigationApp app) {
//         this.app = app;
//         initialize();
//     }

//     public void initialize() {
    public class HostelPage extends Application {

        Label welcome = null;
        private Pane root;

        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setHeight(1000);
            primaryStage.setWidth(1500);
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
        welcome.setPadding(new Insets(10));
        welcome.setFont(Font.font("Maiandra GD", FontWeight.NORMAL, 35));
        welcome.setLayoutX(200);
        welcome.setLayoutY(80);
        
        HBox hb = new HBox(10, imageOfOwner, welcome);
        hb.setPadding(new Insets(40));

        //TitlePane
        TitledPane HostelpageRoot = new TitledPane();
        HostelpageRoot.setAlignment(Pos.TOP_RIGHT);

        //GridPane
        GridPane hostel = new GridPane();
        hostel.setPadding(new Insets(10));
        //Hostel Name
        Label HostelName = new Label("Owner Name :");
        HostelName.setFont(Font.font(null,FontWeight.BOLD,20));
        TextField nameField = new TextField();
        HBox NAmeBox = new HBox(45, HostelName, nameField);

        //Hostel For 
        Label hostelFor = new Label("Hostel For :");
        hostelFor.setFont(Font.font(null,FontWeight.BOLD,20));
        Button girls = new Button("Girls");
        Button Boys = new Button("Boys");
        girls.setFont(Font.font(null,FontWeight.BOLD,15));
        Boys.setFont(Font.font(null,FontWeight.BOLD,15));
        girls.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //Logic for Girls Text
            }
        });
        Boys.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //Logic for Boys Text
            }
        });
        HBox genderButtonBox = new HBox(28, girls, Boys);
        HBox forbutton = new HBox(40, hostelFor, genderButtonBox);

        //Building/Project/Society Name
        Label own = new Label("Hostel Own by :");
        own.setFont(Font.font(null,FontWeight.BOLD,20));
        Button owner = new Button("College");
        owner.setFont(Font.font(null,FontWeight.BOLD,15));
        Button pvtOwner = new Button("Private");
        pvtOwner.setFont(Font.font(null,FontWeight.BOLD,15));
        TextField collegeName = new TextField();
        collegeName.setPromptText("Enter College Name");
        owner.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                TextField collegeName = new TextField();
                collegeName.setPromptText("Enter College Name");
                //getText Logic
            }
        });
        HBox buttonBox = new HBox(28, owner, pvtOwner);
        HBox ownBox = new HBox(28, own, buttonBox);

        //Address 
        Label address = new Label("Address :");
        address.setFont(Font.font(null,FontWeight.BOLD,20));
        TextField addressField = new TextField();
        HBox addressBox = new HBox(65, address, addressField);

        //Number of Beds 
        Label NOB = new Label("Number\n of Beds :");
        NOB.setFont(Font.font(null,FontWeight.BOLD,20));
        TextField nobField = new TextField();
        HBox bedBox = new HBox(85, NOB, nobField);

        //fees 
        Label fees = new Label("Hostel fees :");
        fees.setFont(Font.font(null,FontWeight.BOLD,20));
        TextField feesField = new TextField();
        HBox feesBox = new HBox(60, fees, feesField);

        //Deposit 
        Label deposit = new Label("Deposit :");
        deposit.setFont(Font.font(null,FontWeight.BOLD,20));
        TextField depositField = new TextField();
        HBox depositBox = new HBox(70, deposit, depositField);

        //Photo 
        Label photo = new Label("Photo :");
        photo.setFont(Font.font(null,FontWeight.BOLD,20));
        
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
        VBox vBox = new VBox(50, NAmeBox, forbutton, ownBox, addressBox, bedBox, feesBox, depositBox, photoBox);

        VBox vb = new VBox(vBox);
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-padding:50");// +
        //     "-fx-background-color: #FF0000" +  
        //     "-fx-border-style: solid inside" +
        //         "-fx-border-width: 5" +
        //        "-fx-border-height: 100" + 
        //         "-fx-border-radius: 5");
        vb.setLayoutX(300);
        vb.setLayoutY(200);
   
        //vb.setPadding(new Insets(20));

        hostel.add(vb, 1, 1);
        HostelpageRoot.setContent(vb);
        HostelpageRoot.setText("Hostel");
        HostelpageRoot.setFont(Font.font(null,FontWeight.BOLD,15));
        HostelpageRoot.setAlignment(Pos.CENTER);
        HostelpageRoot.setExpanded(false);
        
        HBox hostelBox = new HBox(HostelpageRoot);
        hostelBox.setLayoutX(100);
        hostelBox.setLayoutY(200);

        // Button next = new Button("Next");
        // next.setOnAction(new EventHandler<ActionEvent>() {
        //     public void handle(ActionEvent event) {
        //         app.navigateToFlatPage();
        //     }
        // });
        root.getChildren().addAll(hb,hostelBox);


        Group group = new Group(root);

        Scene sc = new Scene(group);
        primaryStage.setScene(sc);
        primaryStage.setWidth(1500);
        primaryStage.setHeight(1000);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    // public Pane getView() {

    //     return root;

    // }

}