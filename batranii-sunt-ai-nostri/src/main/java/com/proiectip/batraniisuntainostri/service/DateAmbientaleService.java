package com.proiectip.batraniisuntainostri.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.proiectip.batraniisuntainostri.data.model.DateAmbientale;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Service
public class DateAmbientaleService {

    public DateAmbientaleService() {
    }

    public List<DateAmbientale> gasesteDateAmbientale(final long pacientId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReferences= dbFirestore.collection("date_ambientale").listDocuments();

        List<DateAmbientale> dateAmbientale = new ArrayList<>();

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            DateAmbientale dateAmbientale1 = null;

            if (document.exists() && Objects.requireNonNull(document.toObject(DateAmbientale.class)).getPacient() == pacientId ) {
                dateAmbientale1 = document.toObject(DateAmbientale.class);
                dateAmbientale.add(dateAmbientale1);
            }
        }

        return dateAmbientale;
    }
}
