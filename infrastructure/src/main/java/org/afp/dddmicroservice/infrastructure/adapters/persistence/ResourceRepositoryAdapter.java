package org.afp.dddmicroservice.infrastructure.adapters.persistence;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.afp.dddmicroservice.core.domains.resource.Resource;
import org.afp.dddmicroservice.core.ports.outgoing.ResourceRepositoryPort;
import org.afp.dddmicroservice.infrastructure.mappers.ResourceEntityMapper;
import org.afp.dddmicroservice.infrastructure.repositories.ResourceMySQLJPARepository;
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
    var resources =
        resourceMySQLJPARepository.findAll().stream()
            .map(resourceEntityMapper::resourceEntityToResource)
            .collect(Collectors.toList());
    return Flux.fromIterable(resources);
  }

  @Override
  public List<Resource> getResource() {
    return resourceMySQLJPARepository.findAll().stream()
        .map(resourceEntityMapper::resourceEntityToResource)
        .collect(Collectors.toList());
  }

  @Override
  public Mono<Resource> save(Resource resource) {
    var savedEntity =
        resourceMySQLJPARepository.save(resourceEntityMapper.resourceToResourceEntity(resource));
    return Mono.just(resourceEntityMapper.resourceEntityToResource(savedEntity));
  }
}
