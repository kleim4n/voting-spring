package com.kleiman.votingspring.controller;

import com.kleiman.votingspring.data.Pauta;
import com.kleiman.votingspring.data.PautaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PautaController {
    @Autowired
    private PautaRepository pautaRepository;
    @GetMapping("/pauta/list-all")
    public List<Pauta> getAllPautas() {
        return (List<Pauta>) pautaRepository.findAll();
    }
    @PostMapping("/pauta/create")
    public Pauta createPauta(@Valid @RequestBody Pauta pauta) {
        return pautaRepository.save(pauta);
    }
}
