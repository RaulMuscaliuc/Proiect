package com.proiectip.batraniisuntainostri.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.proiectip.batraniisuntainostri.data.model.*;
import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Service
public class PacientService {

    private final DiagnosticService diagnosticService;
    private final AlergiiService alergiiService;
    private final DateFiziologiceService dateFiziologiceService;
    private final DateAmbientaleService dateAmbientaleService;
    private final TratamentService tratamentService;

    public PacientService(DiagnosticService diagnosticService,
                          AlergiiService alergiiService, DateFiziologiceService dateFiziologiceService,
                          DateAmbientaleService dateAmbientaleService, TratamentService tratamentService) {
        this.diagnosticService = diagnosticService;
        this.alergiiService = alergiiService;
        this.dateFiziologiceService = dateFiziologiceService;
        this.dateAmbientaleService = dateAmbientaleService;
        this.tratamentService = tratamentService;
    }

    public List<Pacient> getAllFromFireBase(final String role, final String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReferences= dbFirestore.collection("pacienti").listDocuments();

        List<Pacient> pacienti = new ArrayList<>();

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            Pacient pacient = null;

            if (document.exists()) {
                pacient = Objects.requireNonNull(document.toObject(Pacient.class));
                switch (role) {
                    case "medic":
                        if(pacient.getMedic() == Long.parseLong(id)) {
                            pacienti.add(pacient);
                        }
                        break;
                    case "supraveghetor":
                        if(pacient.getSupraveghetor() == Long.parseLong(id)) {
                            pacienti.add(pacient);
                        }
                        break;
                    case "ingrijitor":
                        if(pacient.getIngrijitor() == Long.parseLong(id)) {
                            pacienti.add(pacient);
                        }
                        break;
                }

            }
        }

        return pacienti;
    }

    public Pacient getOne(long id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReferences= dbFirestore.collection("pacienti").listDocuments();

        Pacient pacient = null;

        for (DocumentReference reference: documentReferences) {
            ApiFuture<DocumentSnapshot> future = reference.get();
            DocumentSnapshot document = future.get();

            if (document.exists() && Objects.requireNonNull(document.toObject(Pacient.class)).getId() == id) {
                pacient = document.toObject(Pacient.class);
            }
        }

        if(pacient != null) {
            List<Diagnostic> diagnostice = diagnosticService.gasesteDiagnostic(id);
            List<Alergie> alergii = alergiiService.gasesteAlergii(id);
            List<DateFiziologice> dateFiziologice = dateFiziologiceService.gasesteDateFiziologice(id);
            List<DateAmbientale> dateAmbientale = dateAmbientaleService.gasesteDateAmbientale(id);
            List<Tratament> tratamente = tratamentService.gasesteTratamente(id);

            pacient.setTratamente(tratamente);
            pacient.setDateAmbientale(dateAmbientale);
            pacient.setDateFiziologice(dateFiziologice);
            pacient.setDiagnostice(diagnostice);
            pacient.setAlergii(alergii);
        }



        return pacient;
    }

 /*   public void adaugaPacient(final Pacient pacient) {
        pacientRepo.save(pacient);
    }

    public void stergePacient(final long id) {
        pacientRepo.deleteById(id);
    }*/
}
