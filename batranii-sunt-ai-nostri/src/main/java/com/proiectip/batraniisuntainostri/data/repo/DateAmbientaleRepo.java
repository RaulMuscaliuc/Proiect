package com.proiectip.batraniisuntainostri.data.repo;

import com.proiectip.batraniisuntainostri.data.model.DateAmbientale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DateAmbientaleRepo extends JpaRepository<DateAmbientale, Long> {

    @Query(
            "select da from DateAmbientale da where da.pacient.id = :pacientId"
    )
    List<DateAmbientale> gasesteDateAmbientalePentruPacient(long pacientId);
}
