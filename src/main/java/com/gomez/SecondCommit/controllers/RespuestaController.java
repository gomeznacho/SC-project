package com.gomez.SecondCommit.controllers;

import com.gomez.SecondCommit.entities.Pregunta;
import com.gomez.SecondCommit.entities.Respuesta;
import com.gomez.SecondCommit.services.RespuestaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/respuestas")
public class RespuestaController {

    private final RespuestaService respuestaService;

    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @PostMapping
    public ResponseEntity<Respuesta> postRespuesta(@RequestBody Respuesta respuesta){

        return ResponseEntity.ok(respuestaService.save(respuesta));
    }
}
