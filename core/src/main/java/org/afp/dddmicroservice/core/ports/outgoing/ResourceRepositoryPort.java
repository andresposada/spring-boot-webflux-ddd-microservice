package org.afp.dddmicroservice.core.ports.outgoing;

import org.afp.dddmicroservice.core.domains.resource.Resource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ResourceRepositoryPort {

  Flux<Resource> getResources();

  Mono<Resource> save(Resource resource);
}
