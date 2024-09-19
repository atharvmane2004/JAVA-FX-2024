// package com.pgrental.firebase_connection;

// import java.io.OutputStream;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import java.nio.charset.StandardCharsets;

// import org.json.JSONObject;

// import com.pgrental.controller.LoginController;
// import com.google.firebase.auth.FirebaseAuth;
// import com.google.firebase.auth.FirebaseAuthException;
// import com.google.firebase.auth.UserRecord;

// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.VBox;

// public class FirebaseService {
//     private TextField emailField;
//     private PasswordField passwordField;
//     private LoginController loginController;

//     public  FirebaseService(LoginController loginController, TextField emailField, PasswordField passwordField) {
//         this.loginController = loginController;
//         this.emailField = emailField;
//         this.passwordField = passwordField;
//     }

//     public FirebaseService(controller.LoginController loginController2, TextField emailField2,
//             PasswordField passwordField2) {
//         //TODO Auto-generated constructor stub
//     }

//     public boolean signUp() {
//         String email = emailField.getText();
//         String password = passwordField.getText();

//         try {

//             UserRecord.CreateRequest request = new UserRecord.CreateRequest()
//                     .setEmail(email)
//                     .setPassword(password)
//                     .setDisabled(false);

//             UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
//             System.out.println("Successfully created user : " + userRecord.getUid());
//             showAlert("Success", "User created successfully.");
//             return true;
//         } catch (FirebaseAuthException e) {
//             e.printStackTrace();
//             showAlert("Error", "Failed to create user : " + e.getMessage());
//             return false;
//         }
//      }

//      public boolean login() {
//         String email = emailField.getText();
//         String password = passwordField.getText();

//         try {
//             String apiKey = "AIzaSyC0dZ9HIlC9XYj1VsbkNkpUfEtk2oJ_XzU";

//             URL url = new URL("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + apiKey);
//             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//             conn.setRequestMethod("POST");
//             conn.setRequestProperty("Content-Type", "application/json; charset-UTF-8");
//             conn.setDoOutput(true);

//             JSONObject jsonRequest = new JSONObject();
//             jsonRequest.put("email", email);
//             jsonRequest.put("password", password);
//             jsonRequest.put("returnSecureToken", true);

//             try (OutputStream os = conn.getOutputStream()) {
//                 byte[] input = jsonRequest.toString().getBytes(StandardCharsets.UTF_8);
//                 os.write(input, 0, input.length);
//             }

//             if(conn.getResponseCode() == 200){
//                 showAlert(true);
//                 return true;
//              }
//              else{
//                 showAlert("Invalid Login", "Invalid Credintials");
//                 return false;
//              }
//             }catch(Exception e){
//                 e.printStackTrace();
//                 showAlert(false);
//                 return false;
//             }
//     }

//     private void showAlert(String title, String message) {
//         Alert alert = new Alert(Alert.AlertType.INFORMATION);
//         alert.setTitle(title);
//         alert.setHeaderText(null);
//         alert.setContentText(message);
//         alert.showAndWait();
//     }

//     public void showAlert(boolean isLoggedIn){
//         Label msg = new Label("Welcome");
//         msg.setAlignment(Pos.CENTER);

//         Button logoutButton = new Button("Logout");

//         VBox vBox = new VBox(100,msg,logoutButton);

//         logoutButton.setOnAction(new EventHandler<ActionEvent>() {

//             @Override
//             public void handle(ActionEvent event) {
//                 loginController.initializeLoginScene();
//             }

//         });

//         Scene scene = new Scene(vBox,400,200);
//         loginController.setPrimaryStageScene(scene);

//     }
// }/

// package com.pgrental.firebase_connection;

// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;
// import java.util.concurrent.ExecutionException;

// import com.google.api.core.ApiFuture;
// import com.google.cloud.firestore.CollectionReference;
// import com.google.cloud.firestore.DocumentReference;
// import com.google.cloud.firestore.DocumentSnapshot;
// import com.google.cloud.firestore.Firestore;
// import com.google.cloud.firestore.Query;
// import com.google.cloud.firestore.QueryDocumentSnapshot;
// import com.google.cloud.firestore.QuerySnapshot;
// import com.google.cloud.firestore.WriteResult;

// /**
//  * Data Access Object (DAO) class for Player entities.
//  */
// public class firebase_Services {
//     public static Firestore db;

//     public firebase_Services() {
//     }

//     public void addData(String collection, String document, Player data) throws ExecutionException, InterruptedException {
//         DocumentReference c2w_pi_docRef = db.collection(collection).document(document); // Reference to the document
//         ApiFuture<WriteResult> result = c2w_pi_docRef.set(data); // Set data in the document
//         result.get(); // Block until operation is complete
//     }

//     public Player getData(String collection, String document) throws ExecutionException, InterruptedException {
//         try {
//             DocumentReference c2w_pi_docRef = db.collection(collection).document(document); // Reference to the document
//             ApiFuture<DocumentSnapshot> future = c2w_pi_docRef.get(); // Asynchronously retrieve document snapshot
//             return future.get().toObject(Player.class); // Convert document snapshot to Player object
//         } catch (Exception e) {
//             e.printStackTrace(); // Print stack trace for debugging
//             throw e; // Re-throw exception or handle based on application's needs
//         }
//     }


//     public List<Player> getDataList(String collection) throws ExecutionException, InterruptedException {
//         try {
//             CollectionReference colRef = db.collection(collection); // Reference to the collection
//             ApiFuture<QuerySnapshot> future = colRef.get(); // Asynchronously retrieve all documents in collection
//             QuerySnapshot querySnapshot = future.get();
//             List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments(); // Extract list of document snapshots
//             List<Player> dataList = new ArrayList<>();
//             for (QueryDocumentSnapshot document : documents) {
//                 Player object = document.toObject(Player.class); // Convert each document snapshot to Player object
//                 dataList.add(object); // Add Player object to list
//             }
//             return dataList; // Return list of Player objects
//         } catch (Exception e) {
//             e.printStackTrace(); // Print stack trace for debugging
//             throw e; // Re-throw exception or handle based on application's needs
//         }
//     }


//     public List<Player> getDataList(String collection, String country) throws ExecutionException, InterruptedException {
//         try {
//             CollectionReference colRef = db.collection(collection); // Reference to the collection
//             Query query = colRef.whereEqualTo("country", country); // Query to filter documents by country
//             ApiFuture<QuerySnapshot> future = query.get(); // Asynchronously retrieve filtered query snapshot
//             QuerySnapshot querySnapshot = future.get(); // Get query snapshot containing filtered documents
//             List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments(); // Extract list of document snapshots
//             List<Player> dataList = new ArrayList<>();
//             for (QueryDocumentSnapshot document : documents) {
//                 Player object = document.toObject(Player.class); // Convert each document snapshot to Player object
//                 dataList.add(object); // Add Player object to list
//             }
//             return dataList; // Return filtered list of Player objects
//         } catch (Exception e) {
//             e.printStackTrace(); // Print stack trace for debugging
//             throw e; // Re-throw exception or handle based on application's needs
//         }
//     }

//     public List<Player> getSearchPlayer(String key) throws ExecutionException, InterruptedException {
//         CollectionReference c2w_pi_players = db.collection("player"); // Reference to the "player" collection
//         Query nameQuery = c2w_pi_players.whereEqualTo("playerName", key); // Query to filter by playerName
//         Query c2w_pi_countryQuery = c2w_pi_players.whereEqualTo("country", key); // Query to filter by country
//         ApiFuture<QuerySnapshot> nameQuerySnapshot = nameQuery.get(); // Asynchronously retrieve query snapshot for playerName
//         ApiFuture<QuerySnapshot> countryQuerySnapshot = c2w_pi_countryQuery.get(); // Asynchronously retrieve query snapshot for country
//         List<QueryDocumentSnapshot> c2w_pi_nameDocuments = nameQuerySnapshot.get().getDocuments(); // Get documents matching playerName query
//         List<QueryDocumentSnapshot> countryDocuments = countryQuerySnapshot.get().getDocuments(); // Get documents matching country query
//         Set<DocumentSnapshot> uniqueDocuments = new HashSet<>();
//         uniqueDocuments.addAll(c2w_pi_nameDocuments); // Add documents from playerName query to set
//         uniqueDocuments.addAll(countryDocuments); // Add documents from country query to set
//         List<Player> userList = new ArrayList<>();
//         for (DocumentSnapshot document : uniqueDocuments) {
//             if (document.exists()) {
//                 Player c2w_pi_user = document.toObject(Player.class); // Convert document snapshot to Player object
//                 userList.add(c2w_pi_user); // Add Player object to list
//             }
//         }
//         return userList; // Return list of Player objects matching search key
//     }
// }



package com.pgrental.firebase_connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import model.UserDetail;

public class DataService {

    private static Firestore db;

    // static {
    //     try {
    //         initializeFirebase();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // private static void initializeFirebase() throws IOException {
    //     FileInputStream serviceAccount = new FileInputStream(
    //             "src\\main\\resources\\abodeify-fx.json");

    //     @SuppressWarnings("deprecation")
    //     FirebaseOptions options = new FirebaseOptions.Builder()
    //             .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    //             .build();

    //     FirebaseApp.initializeApp(options);
    //     db = FirestoreClient.getFirestore();
    // }

    public void addData(String collection, String document, Map<String, Object> data)
            throws ExecutionException, InterruptedException {
                
        DocumentReference docRef = db.collection(collection).document(document);

        ApiFuture<WriteResult> result = docRef.set(data);

        result.get();

    }

    public void addHostelData(String collection, String document, Object data)
            throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection(collection).document(document);

        ApiFuture<WriteResult> result = docRef.set(data);

        result.get();

    }

    public UserDetail getData(String collection, String document)
            throws ExecutionException, InterruptedException {
        try {
            DocumentReference docRef = db.collection(collection).document(document);

            ApiFuture<DocumentSnapshot> future = docRef.get();
            return future.get().toObject(UserDetail.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean authenticateUser(String username, String password) throws ExecutionException, InterruptedException {

        DocumentSnapshot document = db.collection("users").document(username).get().get();
        if (document.exists()) {
            String storedPassword = document.getString("password");
            return password.equals(storedPassword);
        }
        return false;
    }
}