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

import model.flatDetail;

/**
 * Data Access Object (DAO) class for flat entities.
 */
public class flatDao {
    public static Firestore db;

    public flatDao() {
        
    }

    public static void addData(String collection, String document, flatDetail data)
            throws ExecutionException, InterruptedException {
        System.out.println("flat" + db);
        DocumentReference flatdocRef = db.collection(collection).document(document); // Reference to the document

        ApiFuture<WriteResult> result = flatdocRef.set(data); // Set data in the document
        result.get(); // Block until operation is complete
    }

    public static flatDetail getData(String collection, String document)
            throws ExecutionException, InterruptedException {
        try {
            DocumentReference flatdocRef = db.collection(collection).document(document); // Reference to the document
            ApiFuture<DocumentSnapshot> future = flatdocRef.get(); // Asynchronously retrieve document snapshot
            return future.get().toObject(flatDetail.class); // Convert document snapshot to flat object
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

    public List<flatDetail> getDataList(String collection) throws ExecutionException, InterruptedException {
        try {
            CollectionReference colRef = db.collection(collection); // Reference to the collection
            ApiFuture<QuerySnapshot> future = colRef.get(); // Asynchronously retrieve all documents in collection
            QuerySnapshot querySnapshot = future.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments(); // Extract list of document snapshots
            List<flatDetail> dataList = new ArrayList<>();
            for (QueryDocumentSnapshot document : documents) {
                flatDetail object = document.toObject(flatDetail.class); // Convert each document snapshot to flat
                                                                             // object
                dataList.add(object); // Add flat object to list
            }
            return dataList; // Return list of flat objects
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

    // public List<flatDetail> getDataList(String collection, String country)
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
    // List<flatDetail> dataList = new ArrayList<>();
    // for (QueryDocumentSnapshot document : documents) {
    // flatDetail object = document.toObject(flatDetail.class); // Convert each
    // document snapshot to flat object
    // dataList.add(object); // Add flat object to list
    // }
    // return dataList; // Return filtered list of flat objects
    // } catch (Exception e) {
    // e.printStackTrace(); // Print stack trace for debugging
    // throw e; // Re-throw exception or handle based on application's needs
    // }
    // }

    // public List<flatDetail> getSearchflat(String key) throws
    // ExecutionException, InterruptedException {
    // CollectionReference flat = db.collection("flat"); // Reference to the
    // "flat" collection
    // Query nameQuery = flat.whereEqualTo("flatName", key); // Query to filter
    // by flatName
    // Query flatQuery = flat.whereEqualTo("country", key); // Query to filter
    // by country
    // ApiFuture<QuerySnapshot> nameQuerySnapshot = nameQuery.get(); //
    // Asynchronously retrieve query snapshot for flatName
    // ApiFuture<QuerySnapshot> countryQuerySnapshot = flatcountryQuery.get(); //
    // Asynchronously retrieve query snapshot for country
    // List<QueryDocumentSnapshot> flatnameDocuments =
    // nameQuerySnapshot.get().getDocuments(); // Get documents matching flatName
    // query
    // List<QueryDocumentSnapshot> countryDocuments =
    // countryQuerySnapshot.get().getDocuments(); // Get documents matching country
    // query
    // Set<DocumentSnapshot> uniqueDocuments = new HashSet<>();
    // uniqueDocuments.addAll(flatnameDocuments); // Add documents from flatName
    // query to set
    // uniqueDocuments.addAll(countryDocuments); // Add documents from country query
    // to set
    // List<flat> flatList = new ArrayList<>();
    // for (DocumentSnapshot document : uniqueDocuments) {
    // if (document.exists()) {
    // flat flatflat = document.toObject(flat.class); // Convert document
    // snapshot to flat object
    // flatList.add(flatflat); // Add flat object to list
    // }
    // }
    // return flatList; // Return list of flat objects matching search key
    // }
}