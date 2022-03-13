package org.afp.dddmicroservice.infrastructure.adapters.persistence;

import org.afp.dddmicroservice.core.domains.resource.Resource;
import org.afp.dddmicroservice.core.ports.outgoing.ResourceRepositoryPort;
import org.afp.dddmicroservice.infrastructure.adapters.persistence.mappers.ResourceEntityMapper;
import org.afp.dddmicroservice.infrastructure.repositories.ResourceMySQLJPARepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResourceRepositoryAdapter implements ResourceRepositoryPort {

  final ResourceMySQLJPARepository resourceMySQLJPARepository;
  final ResourceEntityMapper resourceEntityMapper;

  @Override
  public Flux<Resource> getResources() {
    return resourceMySQLJPARepository.findAll().map(resourceEntityMapper::resourceEntityToResource);
  }

  @Override
  public Mono<Resource> save(Resource resource) {
    return resourceMySQLJPARepository
        .save(resourceEntityMapper.resourceToResourceEntity(resource))
        .map(resourceEntityMapper::resourceEntityToResource);
  }
}
