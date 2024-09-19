
// package com.pgrental.dataAccess;

// import javafx.collections.FXCollections;
// import javafx.event.ActionEvent;
// import javafx.event.Event;
// import javafx.event.EventHandler;
// import javafx.geometry.Pos;
// import javafx.scene.Node;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.ComboBox;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.*;

// import javafx.scene.text.Font;
// import javafx.scene.text.FontWeight;
// import javafx.stage.Stage;

// public class TenantPageOne2 {

//         private Pane root;
//         private Stage primaryStage;
//         private Scene tenantScene, optionPageScene, UserViewScene;
//         // LoginPage TenantLogin = new LoginPage();
//         // public String TenantName = TenantLogin.statusTenet;

//         public TenantPageOne2() {

//         }

//         //Method To set primary stage
//         public void setTenantPage(Stage primaryStage) {
//                 this.primaryStage = primaryStage;
//         }

//         //Method To set option Page Scene
//         public void setTenantScene(Scene tenantScene) {
//                 this.tenantScene = tenantScene;
//         }

//         @SuppressWarnings("unchecked")
//         public Pane createTenantScene(Runnable TenantBackHandler) {
//                 Image imageHome = new Image("file:src\\main\\resources\\images\\ownerbg.jpg",
//                 1500, 1000, false, false);
//                 BackgroundSize backgroundSize = new BackgroundSize(
//                 BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
//                 BackgroundImage backgroundImage = new BackgroundImage(
//                 imageHome, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
//                 BackgroundPosition.CENTER,
//                 backgroundSize);
//                 Background background = new Background(backgroundImage);

//                 root = new Pane();
//                 root.setBackground(background);

//                 //PG LOGO
//                 Image pgLogo = new Image(getClass().getResourceAsStream("/images/pglogoai.png"), 250, 250, true,false);
                
//                 ImageView pgLogoView = new ImageView(pgLogo);
//                 pgLogoView.setFitHeight(250);
//                 pgLogoView.setFitWidth(250);
                

//                 HBox pgLogoViewvBox = new HBox(pgLogoView); 
//                 pgLogoViewvBox.setLayoutX(500);
//                 pgLogoViewvBox.setLayoutY(500);

//                 //FLAT LOGO
//                 Image flatLogo = new Image(getClass().getResourceAsStream("/images/flat.png"), 250, 250, true,false);
                
//                 ImageView flatLogoView = new ImageView(flatLogo);
//                 // pgLogoView.setBlendMode(BlendMode.COLOR_BURN);
//                 pgLogoView.setFitHeight(250);
//                 pgLogoView.setFitWidth(250);

//                 HBox flatLogoViewvBox = new HBox(flatLogoView); 


//                 //HOSTEL LOGO
//                 Image hostelLogo = new Image(getClass().getResourceAsStream("/images/hostel2.png"), 250, 250, true,false);
                
//                 ImageView hostelLogoView = new ImageView(hostelLogo);
//                 pgLogoView.setFitHeight(250);
//                 pgLogoView.setFitWidth(250);

//                 HBox hostelLogoViewvBox = new HBox(hostelLogoView); 

    

//                 // LABEL TO DISPLAY EVENTS
//                 Label eventStatusLabel = new Label("no menu item selected");
//                 eventStatusLabel.setFont(Font.font("Maiandra GD", FontWeight.BOLD, 20));
//                 eventStatusLabel.setPrefWidth(450);
//                 eventStatusLabel.setStyle(
//                                 "-fx-background-radius: 5em; " +
//                                                 "-fx-min-width: 350px; " +
//                                                 "-fx-min-height: 40px; " +
//                                                 "-fx-max-width: 350px; " +
//                                                 "-fx-max-height: 40px;");
//                 eventStatusLabel.setLayoutX(685);
//                 eventStatusLabel.setLayoutY(800);

//                 //  Create a background image
//                 // Image imageTenant = new
//                 // Image(getClass().getResourceAsStream("/images/wallpaper4.jpg"), 1630, 1000,
//                 // true,
//                 // false);
//                 // BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO,
//                 // BackgroundSize.AUTO, false,
//                 // false,
//                 // false, false);
//                 // BackgroundImage backgroundImage = new BackgroundImage(imageTenant,
//                 // BackgroundRepeat.NO_REPEAT,
//                 // BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
//                 // Background background = new Background(backgroundImage);

//                 //Logout Button
//                 Image imagelogout = new Image(getClass().getResourceAsStream("/images/Remove-bg.ai.png"), 1500, 1000, true,
//                                 false);

//                 BackgroundSize logoutbg = new BackgroundSize(
//                         BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
//                 BackgroundImage logoutbgImage = new BackgroundImage(
//                         imagelogout, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
//                         BackgroundPosition.CENTER,
//                         logoutbg);
//                 Background logoutBackground = new Background(logoutbgImage);

        
//                 // CUSTOMER CARE
//                 String customer[] = { "123 ", "456" }; @SuppressWarnings("rawtypes")
//                 ComboBox care_box = new ComboBox<>(FXCollections.observableArrayList(customer));
//                 care_box.setPromptText("Customer Care");
//                 care_box.setLayoutX(1300);
//                 care_box.setLayoutY(50);

//                 // LOGOUT BUTTON
//                 Button logoutButton = new Button();
//                 logoutButton.setFont(new Font(40));
//                 logoutButton.setLayoutX(1230);
//                 logoutButton.setLayoutY(22);
//                 logoutButton.setBackground(logoutBackground);
//                 logoutButton.setOnAction(new EventHandler<ActionEvent>() {
//                     public void handle(ActionEvent event) {
//                             initOptionScene();
//                             primaryStage.setScene(optionPageScene);
//                     }
//                 });

//                 // SEARCH ICON IMAGE
//                 Image searchIcon = new Image(getClass().getResourceAsStream("/images/search2.png"), 1630, 1000, false,
//                                 false);

//                 // Create a Pane and set the background
                
//                 root.setStyle("-Fx-Background-Color: WHITE");
//                 // root.setBackground(background);

//                 // Create ImageView for tenant
//                 Image imageOfTenant = new Image(getClass().getResourceAsStream("/images/tenet3.png"));

//                 ImageView imageOfTenantView = new ImageView(imageOfTenant);
//                 imageOfTenantView.setFitHeight(150);
//                 imageOfTenantView.setFitWidth(150);
//                 imageOfTenantView.setLayoutX(20);
//                 imageOfTenantView.setLayoutY(25);

//                 // Create welcome label
//                 Label welcome = new Label("WELCOME " + "\n                      " + LoginPage.statusTenet);
//                 welcome.setFont(Font.font("Forte", FontWeight.NORMAL, 45));
//                 welcome.setLayoutX(250);
//                 welcome.setLayoutY(80);

//                 // PROCEED BUTTON
//                 Button proceedButton = new Button("PROCEED ->");
//                 proceedButton.setLayoutX(710);
//                 proceedButton.setLayoutY(850);
//                 proceedButton.setPrefSize(150, 50);
//                 proceedButton.setStyle("-fx-background-radius: 2em;");
//                 proceedButton.setOnAction(new EventHandler<ActionEvent>() {
//                         public void handle(ActionEvent event) {
//                                 initUserView();
//                         }
//                 });

//                 // SEARCH BUTTON
//                 ImageView searchIconnView = new ImageView(searchIcon);
//                 searchIconnView.setFitHeight(20);
//                 searchIconnView.setFitWidth(20);

//                 Button searchButton = new Button();
//                 searchButton.setGraphic(searchIconnView);
//                 searchButton.setLayoutX(630);
//                 searchButton.setLayoutY(630);
//                 searchButton.setPrefSize(60, 60);
//                 searchButton.setStyle("-fx-background-radius: 2em;");

//                 // LOCATION TEXTFIELD
//                 TextField locationTextField = new TextField();
//                 locationTextField.setPromptText("Enter the Location");
//                 locationTextField.setFont(Font.font("Maiandra GD", FontWeight.NORMAL, 20));
//                 locationTextField.setAlignment(Pos.CENTER);
//                 ((Node) locationTextField).setStyle(
//                                 "-fx-background-radius: 5em; " +
//                                                 "-fx-min-width: 1100px; " +
//                                                 "-fx-min-height: 60px; " +
//                                                 "-fx-max-width: 1100px; " +
//                                                 "-fx-max-height: 60px;");
//                 locationTextField.setLayoutX(630);

//                 // LOCATION HBOX
//                 HBox locationHbox = new HBox(locationTextField, searchButton);
//                 locationHbox.setLayoutX(200);
//                 locationHbox.setLayoutY(200);

//                 // PG ELEMENTS
//                 String pg_contents[] = { "SINGLE ROOM ", "SHARING" };

//                 // PG COMBO BOX
//                 @SuppressWarnings("rawtypes")
//                 ComboBox pgcombo_box = new ComboBox(FXCollections.observableArrayList(pg_contents));
//                 pgcombo_box.setValue("PAYING GUEST");
//                 pgcombo_box.setLayoutX(160);
//                 pgcombo_box.setLayoutY(630);

//                 String memberCount[] = { "2", "3","4"};
//                 @SuppressWarnings("rawtypes")
//                 ComboBox countComboBox = new ComboBox(FXCollections.observableArrayList(memberCount));
//                 countComboBox.setValue("COUNT OF MEMBERS");

//                 VBox vbCountBox = new VBox(countComboBox);
//                 vbCountBox.setVisible(false);
//                 vbCountBox.setLayoutX(160);
//                 vbCountBox.setLayoutY(700);


//                 pgcombo_box.setOnAction(new EventHandler<Event>() {

//                         @Override
//                         public void handle(Event event) {
//                                 eventStatusLabel.setText(pgcombo_box.getValue() + " selected");
//                                 eventStatusLabel.setLayoutX(700);
//                                 if ((pgcombo_box.getValue()).equals("SHARING")) {
//                                         vbCountBox.setVisible(true);
//                                         eventStatusLabel.setLayoutX(690);

//                                 }
//                                 else{
//                                         vbCountBox.setVisible(false);

//                                 }
//                         }
//                 });

//                 // FLAT ELEMENTS
//                 String flat_contents[] = { "1 BHK ", "2 BHK", "3 BHK" };

//                 // FLAT COMBO BOX
//                 @SuppressWarnings("rawtypes")
//                 ComboBox flatcombo_box = new ComboBox(FXCollections.observableArrayList(flat_contents));
//                 flatcombo_box.setValue("FLAT");

//                 flatcombo_box.setOnAction(new EventHandler<Event>() {

//                         @Override
//                         public void handle(Event event) {
//                                 eventStatusLabel.setText(flatcombo_box.getValue() + " selected");
//                                 eventStatusLabel.setLayoutX(720);
                                
//                         }

//                 });
//                 flatcombo_box.setLayoutX(735);
//                 flatcombo_box.setLayoutY(630);

//                 // FLAT ELEMENTS
//                 String hostel_contents[] = { "SINHGAD COLLEGE HOSTEL" };

//                 // HOSTEL COMBO BOX
//                 @SuppressWarnings("rawtypes")
//                 ComboBox hostelcombo_box = new ComboBox(FXCollections.observableArrayList(hostel_contents));
//                 hostelcombo_box.setValue("HOSTEL");

//                 hostelcombo_box.setOnAction(new EventHandler<Event>() {

//                         @Override
//                         public void handle(Event event) {
//                                 eventStatusLabel.setText(hostelcombo_box.getValue() + " selected");
//                                 eventStatusLabel.setLayoutX(630);
//                         }

//                 });
//                 hostelcombo_box.setLayoutX(1190);
//                 hostelcombo_box.setLayoutY(630);

//                 // Back Button To Back Page
//                 Button UserViewList = new Button("UserViewList");
//                 UserViewList.setFont(new Font(20));
//                 UserViewList.setLayoutX(150);
//                 UserViewList.setLayoutY(850);
//                 UserViewList.setStyle("-fx-background-radius: 2em;");
//                 UserViewList.setAlignment(Pos.CENTER);

//                 UserViewList.setOnAction(new EventHandler<ActionEvent>() {

//                         public void handle(ActionEvent event) {
//                                 initUserView();
//                         }
//                 });

//                 //MAIN HBOX FOR LOGOS 
//                 HBox logosHBox = new HBox(290,pgLogoViewvBox,flatLogoViewvBox,hostelLogoViewvBox);
//                 logosHBox.setLayoutX(120);
//                 logosHBox.setLayoutY(350);
//                 locationHbox.setPrefSize(1500, 200);;

//                 // Add nodes to the root Pane
//                 root.getChildren().addAll(imageOfTenantView, welcome, logoutButton, care_box, locationHbox, pgcombo_box, flatcombo_box,hostelcombo_box, UserViewList, eventStatusLabel, vbCountBox,proceedButton,logosHBox);
//                 return root;
//         }

//         //Method To on Logout Click
//         private void initOptionScene() {
//                 optionPage OptionPage = new optionPage();
//                 OptionPage.setOptionPage(primaryStage);
//                 optionPageScene = new Scene(OptionPage.createOptionScene(this::handleBack), 1500, 1000);
//                 OptionPage.setOptionScene(optionPageScene);
//                 primaryStage.show();
//         }

//         //Method To UserView Page
//         private void initUserView() {
//                 userView UserViewPage = new userView();
//                 UserViewPage.setUserViewPage(primaryStage);
        
//                 UserViewScene = new Scene(UserViewPage.createuserViewScene(this::handleBack), 1500, 1000);
//                 primaryStage.setScene(UserViewScene);
//                 primaryStage.show();
//         }

//         private void handleBack() {
//                 primaryStage.setScene(tenantScene);
//         }

// }