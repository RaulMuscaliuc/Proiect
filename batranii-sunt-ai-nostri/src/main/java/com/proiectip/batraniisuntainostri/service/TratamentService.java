package com.proiectip.batraniisuntainostri.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.proiectip.batraniisuntainostri.data.model.Tratament;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Service
public class TratamentService {


    public TratamentService() {
    }

    public List<Tratament> gasesteTratamente(final long pacientId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReferences= dbFirestore.collection("tratamente").listDocuments();

        List<Tratament> tratamente = new ArrayList<>();

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            Tratament tratament = null;

            if (document.exists() && Objects.requireNonNull(document.toObject(Tratament.class)).getPacient() == pacientId ) {
                tratament = document.toObject(Tratament.class);
                tratamente.add(tratament);
            }
        }

        return tratamente;
    }

    public Tratament gasesteTratament(final long id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReferences= dbFirestore.collection("tratamente").listDocuments();

        Tratament tratament = null;

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            if (document.exists() && Objects.requireNonNull(document.toObject(Tratament.class)).getId() == id ) {
                tratament = document.toObject(Tratament.class);
            }
        }

        return tratament;
    }

    public void modificaTratament(final Tratament tratament) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReferences= dbFirestore.collection("tratamente").listDocuments();

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            if (document.exists() && Objects.requireNonNull(document.toObject(Tratament.class)).getId() == tratament.getId()) {
                ApiFuture<WriteResult> update = document.getReference().set(tratament);
            }
        }
    }

    public void salveazaTratament(final Tratament tratament) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference collectionReferences= dbFirestore.collection("tratamente");

        Iterable<DocumentReference> documentReferences= dbFirestore.collection("tratamente").listDocuments();

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            if (document.exists() && Objects.requireNonNull(document.toObject(Tratament.class)).getId() > tratament.getId()){
                tratament.setId(Objects.requireNonNull(document.toObject(Tratament.class)).getId());
            }
        }

        collectionReferences.add(tratament);
    }
}
