package com.proiectip.batraniisuntainostri.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.proiectip.batraniisuntainostri.data.model.Alergie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Service
public class AlergiiService {

    public AlergiiService() {

    }

    public List<Alergie> gasesteAlergii(long pacientId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReferences= dbFirestore.collection("alergii").listDocuments();

        List<Alergie> alergii = new ArrayList<>();

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            Alergie alergie = null;

            if (document.exists() && Objects.requireNonNull(document.toObject(Alergie.class)).getPacient() == pacientId ) {
                alergie = document.toObject(Alergie.class);
                alergii.add(alergie);
            }
        }

        return alergii;
    }
}
