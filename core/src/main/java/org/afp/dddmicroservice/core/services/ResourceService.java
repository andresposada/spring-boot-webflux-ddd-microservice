package org.afp.dddmicroservice.core.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.afp.dddmicroservice.core.domains.resource.Resource;
import org.afp.dddmicroservice.core.ports.incoming.ResourceUseCase;
import org.afp.dddmicroservice.core.ports.outgoing.ResourceRepositoryPort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
public class ResourceService implements ResourceUseCase {

  final ResourceRepositoryPort resourceRepositoryPort;

  public Flux<Resource> getResources() {
    return Flux.create(emitter -> {
      var future = CompletableFuture.supplyAsync(() -> {
        log.info("Retrieving resources with Completable Future");
        return resourceRepositoryPort.getResource();
      });
      future.whenCompleteAsync((resources, exception) -> {
        if (exception != null) {
          emitter.error(exception);
        } else {
          resources.forEach(emitter::next);
          emitter.complete();
        }
      });
    });
  }

  @Override
  public Flux<Resource> getFluxResource() {
    log.info("Retrieving resources without Completable Future");
    return resourceRepositoryPort.getResources();
  }

  @Override
  public Mono<Resource> saveResource(Resource resource) {
    return resourceRepositoryPort.save(resource);
  }
}
