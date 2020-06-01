package com.proiectip.batraniisuntainostri.data.repo;

import com.proiectip.batraniisuntainostri.data.model.Alergie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlergieRepo extends JpaRepository<Alergie, Long> {

    @Query(
            "select a from Alergie a where a.pacient.id = :pacientId"
    )
    List<Alergie> gasesteAlergiiPentruPacient(long pacientId);
}
