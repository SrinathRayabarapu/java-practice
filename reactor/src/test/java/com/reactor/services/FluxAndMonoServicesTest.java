package com.reactor.services;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

class FluxAndMonoServicesTest {

    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

    @Test
    void fruitsFlux() {
        Flux<String> stringFlux = fluxAndMonoServices.fruitsFlux();
        StepVerifier.create(stringFlux).expectNext("Banana", "Orange", "Apple", "Chikoo", "Mango").verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        Flux<String> stringFlux = fluxAndMonoServices.fruitsFluxMap();
        StepVerifier.create(stringFlux).expectNext("BANANA", "ORANGE", "APPLE", "CHIKOO", "MANGO").verifyComplete();
    }

    @Test
    void mangoMono() {
        Mono<String> stringMono = fluxAndMonoServices.mangoMono();
        StepVerifier.create(stringMono).expectNext("Mango").verifyComplete();
    }

    @Test
    void fruitsFluxFlatMap() {
        Flux<String> stringFlux = fluxAndMonoServices.fruitsFluxFlatMap();
        StepVerifier.create(stringFlux)
//                .expectNext("B", "a", "n", "a", "n", "a", "O", "r", "a", "n", "g", "e")
                .expectNextCount(12)
                .verifyComplete();
    }

    @Test
    void fruitsFluxFlatMapAsync() {
        Flux<String> stringFlux = fluxAndMonoServices.fruitsFluxFlatMapAsync();
        StepVerifier.create(stringFlux)
//                .expectNext("B", "a", "n", "a", "n", "a", "O", "r", "a", "n", "g", "e")
                .expectNextCount(12)
                .verifyComplete();
    }

    @Test
    void mangoMonoFlatMap() {
        Mono<List<String>> listMono = fluxAndMonoServices.mangoMonoFlatMap();
        StepVerifier.create(listMono)
                .expectNext(List.of("M", "a", "n", "g", "o"))
//                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void fruitsFluxConcatMapAsync() {
        Flux<String> stringFlux = fluxAndMonoServices.fruitsFluxConcatMapAsync();
        StepVerifier.create(stringFlux)
//                .expectNext("B", "a", "n", "a", "n", "a", "O", "r", "a", "n", "g", "e")
                .expectNextCount(12)
                .verifyComplete();
    }

    @Test
    void mangoMonoFlatMapToMany() {
        Flux<String> stringFlux = fluxAndMonoServices.mangoMonoFlatMapToMany();
        StepVerifier.create(stringFlux)
//                .expectNext("B", "a", "n", "a", "n", "a", "O", "r", "a", "n", "g", "e")
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransform() {
        Flux<String> stringFlux = fluxAndMonoServices.fruitsFluxTransform(5);
        StepVerifier.create(stringFlux)
//                .expectNext("B", "a", "n", "a", "n", "a", "O", "r", "a", "n", "g", "e")
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransformDefaultIfEmpty() {
        Flux<String> stringFlux = fluxAndMonoServices.fruitsFluxTransformDefaultIfEmpty(15);
        StepVerifier.create(stringFlux)
                .expectNext("Default Fruit!")
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransformSwitchIfEmpty() {
        Flux<String> stringFlux = fluxAndMonoServices.fruitsFluxTransformSwitchIfEmpty(15);
        StepVerifier.create(stringFlux)
                .expectNext("random fruit1", "random fruit2")
                .verifyComplete();
    }
}