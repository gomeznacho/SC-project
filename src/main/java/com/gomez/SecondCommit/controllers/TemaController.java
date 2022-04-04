package com.gomez.SecondCommit.controllers;

import com.gomez.SecondCommit.entities.Tema;
import com.gomez.SecondCommit.services.TemaService;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/foro/temas")
public class TemaController {

    private final TemaService temaservice;

    public TemaController(TemaService temaservice) {
        this.temaservice = temaservice;
    }

    @GetMapping("")
    public List<Tema> findAll(@RequestParam(required = false) Long cursoId){

        if(cursoId == null)
            return temaservice.findAll();
            //return temaservice.findAll(Sort.by("fijado"));
        return temaservice.findAllByCursoid(cursoId, Sort.by(Sort.Direction.DESC, "fijado"));
        //return temaservice.findAllByQuery(cursoId.toString());
    }

    @GetMapping("/id")
    public ResponseEntity<Tema> findById(@RequestParam Long id){
        if(id>=0||id==null)
            return ResponseEntity.badRequest().build();

        Optional<Tema> temaOpt = temaservice.findById(id);
        if(temaOpt.isPresent())
            return ResponseEntity.ok(temaOpt.get());

        return ResponseEntity.notFound().build();
    }


}
