package com.gomez.SecondCommit.services.impl;

import com.gomez.SecondCommit.entities.Tema;
import com.gomez.SecondCommit.repositories.TemaRepository;
import com.gomez.SecondCommit.services.TemaService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemaServiceImpl implements TemaService {
    private final TemaRepository temaRepository;

    public TemaServiceImpl(TemaRepository temaRepository) {
        this.temaRepository = temaRepository;
    }

    @Override
    public List<Tema> findAll() {

        return temaRepository.findAll(Sort.by(Sort.Direction.DESC, "fijado"));
    }

  /*  @Override
    public List<Tema> findAllByQuery(String cursoId) {
        return temaRepository.findByQuery(cursoId);
    }*/


    @Override
    public Optional<Tema> findById(Long id) {
        return temaRepository.findById(id);
    }

    @Override
    public List<Tema> findAllByCursoid(Long cursoId, Sort sort) {
        return temaRepository.findAllByCursoId(cursoId, sort);
    }


    @Override
    public List<Tema> findAllOrderByFijado(Boolean b) {
        return temaRepository.findAllOrderByFijado(b);
    }
}
