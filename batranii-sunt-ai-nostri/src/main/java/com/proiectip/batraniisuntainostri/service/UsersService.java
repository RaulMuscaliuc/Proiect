package com.proiectip.batraniisuntainostri.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.proiectip.batraniisuntainostri.data.model.Tratament;
import com.proiectip.batraniisuntainostri.data.model.Users;
import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Service
public class UsersService {
    public Users verificaDateLogin(final String username, final String password) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReferences= dbFirestore.collection("users").listDocuments();

        Users user = null;

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            if (document.exists() &&
                    Objects.requireNonNull(document.toObject(Users.class)).getUsername().equals(username) &&
                    Objects.requireNonNull(document.toObject(Users.class)).getPassword().equals(password)
            ) {
                user = document.toObject(Users.class);
            }
        }

        return user;
    }

    public void adaugaPacient(final Pacient pacient, final String username, final String password) throws ExecutionException, InterruptedException {
        Users user = new Users();
        user.setId(0);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("pacient");

        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference collectionReferencesUser= dbFirestore.collection("users");
        CollectionReference collectionReferences= dbFirestore.collection("pacienti");

        Iterable<DocumentReference> documentReferences= dbFirestore.collection("users").listDocuments();
        Iterable<DocumentReference> documentReferencesPacienti= dbFirestore.collection("pacienti").listDocuments();

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            if (document.exists()
                    && Objects.requireNonNull(document.toObject(Users.class)).getRole().equals(user.getRole())
                    && Objects.requireNonNull(document.toObject(Users.class)).getId() >= user.getId()){
                user.setId(Objects.requireNonNull(document.toObject(Users.class)).getId() + 1);
            }
        }

        for (DocumentReference reference: documentReferencesPacienti) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            if (document.exists()
                    && Objects.requireNonNull(document.toObject(Pacient.class)).getId() >= pacient.getId()){
                pacient.setId(Objects.requireNonNull(document.toObject(Pacient.class)).getId() + 1);
            }
        }

        collectionReferencesUser.add(user);
        collectionReferences.add(pacient);
    }
}
