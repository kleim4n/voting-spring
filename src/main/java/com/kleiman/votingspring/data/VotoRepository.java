package com.kleiman.votingspring.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends CrudRepository<Voto, Long> {
    @Query("SELECT v FROM Voto v WHERE v.idPauta = ?1 AND v.idAssociado = ?2")
    List<Voto> existsIdAssociadoInVotesByIdPauta(Long idPauta, Long idAssociado);
}
