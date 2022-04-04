package com.gomez.SecondCommit.repositories;

import com.gomez.SecondCommit.entities.Pregunta;
import com.gomez.SecondCommit.entities.Tema;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

    //List<Tema> findAll();

    List<Tema> findAllOrderByFijado(Boolean b);

    List<Tema> findAllByCursoId(Long cursoId, Sort sort);

    /*@Query("SELECT pre.id, pre.tema_id, count(re.pregunta_id)  FROM tema te" +
            "INNER JOIN pregunta pre on pre.tema_id= te.id" +
            "INNER JOIN respuesta re on pre.id = re.pregunta_id" +
            "GROUP BY (pre.id)")
    List <Tema> findByQuery(String cursoId);*/
/*
    @Query
    List<Pregunta> findPreguntas(Long id);*/
}
