package com.proiectip.batraniisuntainostri.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.*;
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

    public void creazaDateAmbientale() throws ExecutionException, InterruptedException {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference dR =  firebaseDatabase.getReference();
        dR.child("Date_ambientale").child("1").addValueEventListener(new ValueEventListener() {
            @lombok.SneakyThrows
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DateAmbientale dateAmbientale = dataSnapshot.getValue(DateAmbientale.class);
                dateAmbientale.setId(0);
                dateAmbientale.setPacient(1);
                System.out.println(dateAmbientale);

                Firestore dbFirestore = FirestoreClient.getFirestore();
                CollectionReference collectionReferences= dbFirestore.collection("date_ambientale");

                Iterable<DocumentReference> documentReferences= dbFirestore.collection("date_ambientale").listDocuments();

                for (DocumentReference reference: documentReferences) {
                    ApiFuture<DocumentSnapshot> future = reference.get();
                    try {
                        DocumentSnapshot document = future.get();
                        if (document.exists() && Objects.requireNonNull(document.toObject(DateAmbientale.class)).getId() >= dateAmbientale.getId()){
                            dateAmbientale.setId(Objects.requireNonNull(document.toObject(DateAmbientale.class)).getId() + 1);
                        }
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    } catch (ExecutionException e) {
                        System.out.println(e);
                    }
                }

                collectionReferences.add(dateAmbientale);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
