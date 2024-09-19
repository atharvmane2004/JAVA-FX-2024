package com.pgrental.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import model.hostelDetail;

/**
 * Data Access Object (DAO) class for hostel entities.
 */
public class hostelDao {
    public static Firestore db;

    public hostelDao() {
    }

    public static void addData(String collection, String document, hostelDetail data)
            throws ExecutionException, InterruptedException {
        System.out.println("hostel" + db);
        DocumentReference hosteldocRef = db.collection(collection).document(document); // Reference to the document

        ApiFuture<WriteResult> result = hosteldocRef.set(data); // Set data in the document
        result.get(); // Block until operation is complete
    }

    public static hostelDetail getData(String collection, String document)
            throws ExecutionException, InterruptedException {
        try {
            DocumentReference hosteldocRef = db.collection(collection).document(document); // Reference to the document
            ApiFuture<DocumentSnapshot> future = hosteldocRef.get(); // Asynchronously retrieve document snapshot
            return future.get().toObject(hostelDetail.class); // Convert document snapshot to hostel object
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

    public List<hostelDetail> getDataList(String collection) throws ExecutionException, InterruptedException {
        try {
            CollectionReference colRef = db.collection(collection); // Reference to the collection
            ApiFuture<QuerySnapshot> future = colRef.get(); // Asynchronously retrieve all documents in collection
            QuerySnapshot querySnapshot = future.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments(); // Extract list of document snapshots
            List<hostelDetail> dataList = new ArrayList<>();
            for (QueryDocumentSnapshot document : documents) {
                hostelDetail object = document.toObject(hostelDetail.class); // Convert each document snapshot to hostel
                                                                             // object
                dataList.add(object); // Add hostel object to list
            }
            return dataList; // Return list of hostel objects
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

    // public List<hostelDetail> getDataList(String collection, String country)
    // throws ExecutionException, InterruptedException {
    // try {
    // CollectionReference colRef = db.collection(collection); // Reference to the
    // collection
    // Query query = colRef.whereEqualTo("country", country); // Query to filter
    // documents by country
    // ApiFuture<QuerySnapshot> future = query.get(); // Asynchronously retrieve
    // filtered query snapshot
    // QuerySnapshot querySnapshot = future.get(); // Get query snapshot containing
    // filtered documents
    // List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments(); //
    // Extract list of document snapshots
    // List<hostelDetail> dataList = new ArrayList<>();
    // for (QueryDocumentSnapshot document : documents) {
    // hostelDetail object = document.toObject(hostelDetail.class); // Convert each
    // document snapshot to hostel object
    // dataList.add(object); // Add hostel object to list
    // }
    // return dataList; // Return filtered list of hostel objects
    // } catch (Exception e) {
    // e.printStackTrace(); // Print stack trace for debugging
    // throw e; // Re-throw exception or handle based on application's needs
    // }
    // }

    // public List<hostelDetail> getSearchhostel(String key) throws
    // ExecutionException, InterruptedException {
    // CollectionReference hostel = db.collection("hostel"); // Reference to the
    // "hostel" collection
    // Query nameQuery = hostel.whereEqualTo("hostelName", key); // Query to filter
    // by hostelName
    // Query hostelQuery = hostel.whereEqualTo("country", key); // Query to filter
    // by country
    // ApiFuture<QuerySnapshot> nameQuerySnapshot = nameQuery.get(); //
    // Asynchronously retrieve query snapshot for hostelName
    // ApiFuture<QuerySnapshot> countryQuerySnapshot = hostelcountryQuery.get(); //
    // Asynchronously retrieve query snapshot for country
    // List<QueryDocumentSnapshot> hostelnameDocuments =
    // nameQuerySnapshot.get().getDocuments(); // Get documents matching hostelName
    // query
    // List<QueryDocumentSnapshot> countryDocuments =
    // countryQuerySnapshot.get().getDocuments(); // Get documents matching country
    // query
    // Set<DocumentSnapshot> uniqueDocuments = new HashSet<>();
    // uniqueDocuments.addAll(hostelnameDocuments); // Add documents from hostelName
    // query to set
    // uniqueDocuments.addAll(countryDocuments); // Add documents from country query
    // to set
    // List<hostel> hostelList = new ArrayList<>();
    // for (DocumentSnapshot document : uniqueDocuments) {
    // if (document.exists()) {
    // hostel hostelhostel = document.toObject(hostel.class); // Convert document
    // snapshot to hostel object
    // hostelList.add(hostelhostel); // Add hostel object to list
    // }
    // }
    // return hostelList; // Return list of hostel objects matching search key
    // }
}