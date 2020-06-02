package com.proiectip.batraniisuntainostri.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.proiectip.batraniisuntainostri.data.model.Diagnostic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Service
public class DiagnosticService {

    public DiagnosticService() {

    }

    public List<Diagnostic> gasesteDiagnostic(final long pacientId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReferences= dbFirestore.collection("diagnostice").listDocuments();

        List<Diagnostic> diagnostice = new ArrayList<>();

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            Diagnostic diagnostic = null;

            if (document.exists() && Objects.requireNonNull(document.toObject(Diagnostic.class)).getPacient() == pacientId ) {
                diagnostic = document.toObject(Diagnostic.class);
                diagnostice.add(diagnostic);
            }
        }

        return diagnostice;
    }
}
