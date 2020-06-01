package com.proiectip.batraniisuntainostri.data.repo;

import com.proiectip.batraniisuntainostri.data.model.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiagnosticRepo extends JpaRepository<Diagnostic, Long> {

    @Query(
            "select d from Diagnostic d where d.pacient.id = :pacientId"
    )
    List<Diagnostic> gasesteDiagnosticePentruPacient(long pacientId);
}
