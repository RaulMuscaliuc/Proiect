package com.proiectip.batraniisuntainostri.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.proiectip.batraniisuntainostri.data.model.DateFiziologice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Service
public class DateFiziologiceService {

    public DateFiziologiceService() {
    }

    public List<DateFiziologice> gasesteDateFiziologice(long pacientId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReferences= dbFirestore.collection("date_fiziologice").listDocuments();

        List<DateFiziologice> dateFiziologice = new ArrayList<>();

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            DateFiziologice dateFiziologice1 = null;

            if (document.exists() && Objects.requireNonNull(document.toObject(DateFiziologice.class)).getPacient() == pacientId ) {
                dateFiziologice1 = document.toObject(DateFiziologice.class);
                dateFiziologice.add(dateFiziologice1);
            }
        }

        return dateFiziologice;
    }
}
