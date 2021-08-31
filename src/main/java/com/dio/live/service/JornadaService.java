package com.dio.live.service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaService {


    JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho salvarJornada(JornadaTrabalho jornadaTrabalho){
       return jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> buscarTodas() {
       return   jornadaRepository.findAll();
    }

    public Optional<JornadaTrabalho> buscarPorId(Long idJornada) {
        return jornadaRepository.findById(idJornada);
    }

    public JornadaTrabalho atualizarJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }

    public void deletarJornada(Long idJornada) {
        jornadaRepository.deleteById(idJornada);
    }
}
