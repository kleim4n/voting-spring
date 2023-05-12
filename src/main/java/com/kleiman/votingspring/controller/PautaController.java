package com.kleiman.votingspring.controller;

import com.kleiman.votingspring.data.Pauta;
import com.kleiman.votingspring.data.PautaRepository;
import com.kleiman.votingspring.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    @PutMapping("/pauta/update/{id}")
    public ResponseEntity<Pauta> updatePauta(@PathVariable(value="id") Long pautaId, @Valid @RequestBody Pauta pautaDetails){
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pauta não encontrada com o id : " + pautaId));
        pauta.setTitulo(pautaDetails.getTitulo());
        pauta.setDescricao(pautaDetails.getDescricao());
        pauta.setAberto(pautaDetails.isAberto());
        final Pauta updatedPauta = pautaRepository.save(pauta);
        return ResponseEntity.ok(updatedPauta);
    }
    @DeleteMapping("/pauta/delete/{id}")
    public Map<String, Boolean> deletePauta(@PathVariable(value="id") Long pautaId){
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pauta não encontrada com o id : " + pautaId));
        pautaRepository.delete(pauta);
        return Map.of("deletado", Boolean.TRUE);
    }
}
