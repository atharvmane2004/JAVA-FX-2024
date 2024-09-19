package com.pgrental.dataAccess;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.TenantInfoDetail;

public class NotificationView {

        private Pane root;
        private Stage primaryStage;
        private Scene OwnerScene;
        private Scene NotificationViewScene;
        LoginPage OwnerLogin = new LoginPage();
        public String OwnerName = OwnerLogin.statusOwner;
        private TenantInfoDetail tf = new TenantInfoDetail();
        private TenantInfo tf2 = new TenantInfo();


        public NotificationView() {

        }

        // Method To set primary stage
        public void setNotificationViewPage(Stage primaryStage) {
                this.primaryStage = primaryStage;
        }

        public Pane createNotificationViewScene(Runnable NotificationViewBackHandler) {
                // public void start(Stage primaryStage) {

                root = new Pane();

                // Back Button To Back Page
                Image imageBack = new Image("file:src\\main\\resources\\images\\backbg.png",
                                1500, 1000, true, false);
                ImageView BackView = new ImageView(imageBack);
                BackView.setFitHeight(40);
                BackView.setFitWidth(45);

                Button Back = new Button();
                Back.setStyle(
                                "-fx-background-radius: 5em; " +
                                                "-fx-min-height: 50px; " +
                                                "-fx-max-width: 30px;");
                Back.setGraphic(BackView);
                Back.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                NotificationViewBackHandler.run();
                        }
                });
                
                // HBox hBox1 = new HBox();
                // HBox hBox2 = new HBox()
                ListView<String> interestListView = new ListView<>();
                interestListView.setBackground(null);

                // interestListView.getItems().add(TenantInfo.fullName+ " is Interested");
                interestListView.getItems().add("Mansi Jagtap is Interested");
                interestListView.getItems().add("Aditya Bhagat is Interested");
                interestListView.setStyle("-fx-background-radius: 2em; -fx-background-color: #FFFFFF;");


                // Notification Text
                Text notification = new Text("Notification");
                notification.setFont(Font.font(null, FontWeight.BOLD, 30));

                // Three Dots To Clear
                Image imageDots = new Image(getClass().getResourceAsStream("/images/vertical-dots.png"), 1500, 1000,
                                true,
                                false);

                BackgroundSize Dotsbg = new BackgroundSize(
                                BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
                BackgroundImage DotsbgImage = new BackgroundImage(imageDots, BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, Dotsbg);
                Background DotsBackground = new Background(DotsbgImage);
                Button Dots = new Button();
                Dots.setBackground(DotsBackground);

                HBox TopView = new HBox(600, Back, notification, Dots);
                TopView.setPadding(new Insets(20));

                ScrollPane scrollPane = new ScrollPane();

                VBox BackBox = new VBox(TopView, scrollPane,interestListView);
                BackBox.setPrefSize(1500, 1000);

                root.getChildren().addAll(BackBox);

                // Scene scene = new Scene(root, 1500, 1000);
                // primaryStage.setScene(scene);
                // primaryStage.setTitle("Home Page Scene");
                // primaryStage.show();
                return root;
        }

}
