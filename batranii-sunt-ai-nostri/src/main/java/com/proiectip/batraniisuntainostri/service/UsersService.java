package com.proiectip.batraniisuntainostri.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.proiectip.batraniisuntainostri.data.model.Users;
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
}
