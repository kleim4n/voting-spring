package com.kleiman.votingspring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends CrudRepository<Pauta, Integer> {
}
