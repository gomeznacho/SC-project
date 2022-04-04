package com.gomez.SecondCommit.services.impl;

import com.gomez.SecondCommit.entities.Pregunta;
import com.gomez.SecondCommit.repositories.PreguntaRepository;
import com.gomez.SecondCommit.services.PreguntaService;
import org.springframework.stereotype.Service;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;

    public PreguntaServiceImpl(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Pregunta save(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }
}
