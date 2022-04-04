package com.gomez.SecondCommit.repositories;

import com.gomez.SecondCommit.entities.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
}
