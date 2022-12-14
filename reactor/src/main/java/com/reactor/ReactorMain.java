package com.reactor;

import com.reactor.services.FluxServices;
import com.reactor.services.MonoServices;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ReactorMain {
    public static void main(String[] args) {

        FluxServices fluxServices = new FluxServices();
        MonoServices monoServices = new MonoServices();

        log.info("From Flux");
        Flux<String> stringFlux = fluxServices.fruitsFlux();
        stringFlux.subscribe(fruit -> log.info(fruit));

        log.info("From Mono");
        monoServices.mangoMono().subscribe(fruit -> log.info(fruit));

    }

}