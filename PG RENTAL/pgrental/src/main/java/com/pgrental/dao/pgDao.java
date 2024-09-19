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

import model.pgDetail;

/**
 * Data Access Object (DAO) class for pg entities.
 */
public class pgDao {
    public static Firestore db;

    public pgDao() {
    }

    public static void addData(String collection, String document, pgDetail data)
            throws ExecutionException, InterruptedException {
        System.out.println("PG" + db);
        DocumentReference pgdocRef = db.collection(collection).document(document); // Reference to the document

        ApiFuture<WriteResult> result = pgdocRef.set(data); // Set data in the document
        result.get(); // Block until operation is complete
    }

    public static pgDetail getData(String collection, String document)
            throws ExecutionException, InterruptedException {
        try {
            DocumentReference pgdocRef = db.collection(collection).document(document); // Reference to the document
            ApiFuture<DocumentSnapshot> future = pgdocRef.get(); // Asynchronously retrieve document snapshot
            return future.get().toObject(pgDetail.class); // Convert document snapshot to pg object
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

    public List<pgDetail> getDataList(String collection) throws ExecutionException, InterruptedException {
        try {
            CollectionReference colRef = db.collection(collection); // Reference to the collection
            ApiFuture<QuerySnapshot> future = colRef.get(); // Asynchronously retrieve all documents in collection
            QuerySnapshot querySnapshot = future.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments(); // Extract list of document snapshots
            List<pgDetail> dataList = new ArrayList<>();
            for (QueryDocumentSnapshot document : documents) {
                pgDetail object = document.toObject(pgDetail.class); // Convert each document snapshot to pg
                                                                             // object
                dataList.add(object); // Add pg object to list
            }
            return dataList; // Return list of pg objects
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

    // public List<pgDetail> getDataList(String collection, String country)
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
    // List<pgDetail> dataList = new ArrayList<>();
    // for (QueryDocumentSnapshot document : documents) {
    // pgDetail object = document.toObject(pgDetail.class); // Convert each
    // document snapshot to pg object
    // dataList.add(object); // Add pg object to list
    // }
    // return dataList; // Return filtered list of pg objects
    // } catch (Exception e) {
    // e.printStackTrace(); // Print stack trace for debugging
    // throw e; // Re-throw exception or handle based on application's needs
    // }
    // }

    // public List<pgDetail> getSearchpg(String key) throws
    // ExecutionException, InterruptedException {
    // CollectionReference pg = db.collection("pg"); // Reference to the
    // "pg" collection
    // Query nameQuery = pg.whereEqualTo("pgName", key); // Query to filter
    // by pgName
    // Query pgQuery = pg.whereEqualTo("country", key); // Query to filter
    // by country
    // ApiFuture<QuerySnapshot> nameQuerySnapshot = nameQuery.get(); //
    // Asynchronously retrieve query snapshot for pgName
    // ApiFuture<QuerySnapshot> countryQuerySnapshot = pgcountryQuery.get(); //
    // Asynchronously retrieve query snapshot for country
    // List<QueryDocumentSnapshot> pgnameDocuments =
    // nameQuerySnapshot.get().getDocuments(); // Get documents matching pgName
    // query
    // List<QueryDocumentSnapshot> countryDocuments =
    // countryQuerySnapshot.get().getDocuments(); // Get documents matching country
    // query
    // Set<DocumentSnapshot> uniqueDocuments = new HashSet<>();
    // uniqueDocuments.addAll(pgnameDocuments); // Add documents from pgName
    // query to set
    // uniqueDocuments.addAll(countryDocuments); // Add documents from country query
    // to set
    // List<pg> pgList = new ArrayList<>();
    // for (DocumentSnapshot document : uniqueDocuments) {
    // if (document.exists()) {
    // pg pgpg = document.toObject(pg.class); // Convert document
    // snapshot to pg object
    // pgList.add(pgpg); // Add pg object to list
    // }
    // }
    // return pgList; // Return list of pg objects matching search key
    // }
}