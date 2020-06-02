package com.proiectip.batraniisuntainostri.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
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

    /*public Tratament gasesteTratament(final long id) {
        return tratamentRepo.findByid(id);
    }

    public void salveazaTratament(final Tratament tratament) {
        tratamentRepo.save(tratament);
    }*/
}
