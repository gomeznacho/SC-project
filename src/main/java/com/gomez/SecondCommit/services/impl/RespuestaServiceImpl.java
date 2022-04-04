package com.gomez.SecondCommit.services.impl;

import com.gomez.SecondCommit.entities.Pregunta;
import com.gomez.SecondCommit.entities.Respuesta;
import com.gomez.SecondCommit.repositories.PreguntaRepository;
import com.gomez.SecondCommit.repositories.RespuestaRepository;
import com.gomez.SecondCommit.services.RespuestaService;
import org.springframework.stereotype.Service;

@Service
public class RespuestaServiceImpl implements RespuestaService {
    private final RespuestaRepository respuestaRepo;


    public RespuestaServiceImpl(RespuestaRepository respuestaRepo) {
        this.respuestaRepo = respuestaRepo;

    }

    @Override
    public Respuesta save(Respuesta respuesta) {
        respuestaRepo.save(respuesta);

        return respuesta;
    }
}
