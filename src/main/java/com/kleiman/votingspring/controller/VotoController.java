package com.kleiman.votingspring.controller;

import com.kleiman.votingspring.data.Pauta;
import com.kleiman.votingspring.data.Voto;
import com.kleiman.votingspring.data.VotoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VotoController {
    @Autowired
    private VotoRepository votoRepository;
    @Autowired
    private PautaController pautaController;
    @GetMapping("/voto/list-all")
    public List<Voto> getAllVotos() {
        return (List<Voto>) votoRepository.findAll();
    }
    @PostMapping("/voto/create")
    public Voto createVoto(@Valid @RequestBody Voto voto) {
        pautaController.getPautaById(voto.getIdPauta());
        return votoRepository.save(voto);
    }
    @DeleteMapping("/voto/delete/{id}")
    public void deleteVoto(@PathVariable(value = "id") Long votoId) {
        Voto voto = votoRepository.findById(votoId)
                .orElseThrow(() -> new RuntimeException("Voto não encontrado com o id : " + votoId));
        votoRepository.delete(voto);
    }
}
