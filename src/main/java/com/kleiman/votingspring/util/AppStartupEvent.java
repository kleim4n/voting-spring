package com.kleiman.votingspring.util;

import com.kleiman.votingspring.data.Pauta;
import com.kleiman.votingspring.data.PautaRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final PautaRepository pautaRepository;

    public AppStartupEvent(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Pauta> pautas = this.pautaRepository.findAll();
        pautas.forEach(System.out::println);
    }
}
