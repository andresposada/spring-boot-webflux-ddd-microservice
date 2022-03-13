package org.afp.dddmicroservice.core.ports.incoming;

import org.afp.dddmicroservice.core.domains.resource.Resource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ResourceUseCase {
  Flux<Resource> getResources();

  Mono<Resource> saveResource(Resource resource);
}
