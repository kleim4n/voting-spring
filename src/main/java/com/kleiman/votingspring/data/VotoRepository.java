package com.kleiman.votingspring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends CrudRepository<Voto, Long> {
}
