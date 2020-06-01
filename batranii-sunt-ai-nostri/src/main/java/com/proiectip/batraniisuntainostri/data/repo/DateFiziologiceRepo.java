package com.proiectip.batraniisuntainostri.data.repo;

import com.proiectip.batraniisuntainostri.data.model.DateFiziologice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DateFiziologiceRepo extends JpaRepository<DateFiziologice, Long> {
    @Query(
            "select df from DateFiziologice df where df.pacient.id = :pacientId"
    )
    List<DateFiziologice> gasesteDateFiziologicePentruPacient(long pacientId);
}
