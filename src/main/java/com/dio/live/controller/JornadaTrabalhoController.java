package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho criarJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.salvarJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> buscarTodasJornadas(){
        return jornadaService.buscarTodas();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> buscarJornadaPorId(@PathVariable("idJornada") Long idJornada) throws Exception {
        return ResponseEntity.ok(jornadaService.buscarPorId(idJornada).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public JornadaTrabalho atualizarJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.atualizarJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deletarPorId(@PathVariable("idJornada") Long idJornada) throws Exception {
       try {
           jornadaService.deletarJornada(idJornada);
       } catch (Exception e){
           System.out.println(e.getMessage());
       }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
    }

}
