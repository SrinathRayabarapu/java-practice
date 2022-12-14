package com.reactor;

import com.reactor.services.FluxAndMonoServices;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ReactorMain {
    public static void main(String[] args) {

        FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

        log.info("From Flux");
        Flux<String> stringFlux = fluxAndMonoServices.fruitsFlux();
        stringFlux.subscribe(fruit -> log.info(fruit));

        log.info("From Mono");
        fluxAndMonoServices.mangoMono().subscribe(fruit -> log.info(fruit));

    }

}