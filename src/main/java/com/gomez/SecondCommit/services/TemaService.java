package com.gomez.SecondCommit.services;

import com.gomez.SecondCommit.entities.Tema;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface TemaService {
    List<Tema> findAll();

   // List<Tema> findAllByQuery(String cursoId);

    Optional<Tema> findById(Long id);

    List<Tema> findAllByCursoid(Long cursoId, Sort sort);

    List <Tema> findAllOrderByFijado(Boolean b);
}
