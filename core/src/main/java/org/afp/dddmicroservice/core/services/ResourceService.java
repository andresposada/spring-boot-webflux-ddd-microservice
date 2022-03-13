package org.afp.dddmicroservice.core.services;

import org.afp.dddmicroservice.core.domains.resource.Resource;
import org.afp.dddmicroservice.core.ports.incoming.ResourceUseCase;
import org.afp.dddmicroservice.core.ports.outgoing.ResourceRepositoryPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ResourceService implements ResourceUseCase {

  final ResourceRepositoryPort resourceRepositoryPort;

  public Flux<Resource> getResources() {
    return resourceRepositoryPort.getResources();
  }

  @Override
  public Mono<Resource> saveResource(Resource resource) {
    return resourceRepositoryPort.save(resource);
  }
}
