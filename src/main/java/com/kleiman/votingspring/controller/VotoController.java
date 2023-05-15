package com.kleiman.votingspring.controller;

import com.kleiman.votingspring.data.Pauta;
import com.kleiman.votingspring.data.Voto;
import com.kleiman.votingspring.data.VotoRepository;
import com.kleiman.votingspring.exception.BadRequestException;
import com.kleiman.votingspring.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        if (votoRepository.existsIdAssociadoInVotesByIdPauta(voto.getIdPauta(), voto.getIdAssociado()).size() > 0)
            throw new BadRequestException("Associado já votou nesta pauta");
        return votoRepository.save(voto);
    }
    @DeleteMapping("/voto/delete/{id}")
    public Map<String, Boolean> deleteVoto(@PathVariable(value = "id") Long votoId) {
        Voto voto = votoRepository.findById(votoId)
                .orElseThrow(() -> new ResourceNotFoundException("Voto não encontrado com o id : " + votoId));
        votoRepository.delete(voto);
        return Map.of("deletado", Boolean.TRUE);
    }
}
