package com.kleiman.votingspring.controller;

import com.kleiman.votingspring.data.Pauta;
import com.kleiman.votingspring.data.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
