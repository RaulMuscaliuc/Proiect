package com.proiectip.batraniisuntainostri.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.proiectip.batraniisuntainostri.data.model.Recomandare;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Service
public class RecomandareService {


    public List<Recomandare> gasesteRecomandari(long pacientId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReferences= dbFirestore.collection("recomandari").listDocuments();

        List<Recomandare> recomandari = new ArrayList<>();

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            Recomandare recomandare = null;

            if (document.exists() && Objects.requireNonNull(document.toObject(Recomandare.class)).getPacient() == pacientId ) {
                recomandare = document.toObject(Recomandare.class);
                recomandari.add(recomandare);
            }
        }

        return recomandari;
    }

    public void salveazaRecomandare(final Recomandare recomandare) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference collectionReferences= dbFirestore.collection("recomandari");

        Iterable<DocumentReference> documentReferences= dbFirestore.collection("recomandari").listDocuments();

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            if (document.exists() && Objects.requireNonNull(document.toObject(Recomandare.class)).getId() > recomandare.getId()){
                recomandare.setId(Objects.requireNonNull(document.toObject(Recomandare.class)).getId());
            }
        }

        collectionReferences.add(recomandare);
    }
}
