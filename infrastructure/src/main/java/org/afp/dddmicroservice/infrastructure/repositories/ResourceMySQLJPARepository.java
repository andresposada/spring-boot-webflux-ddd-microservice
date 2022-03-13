package org.afp.dddmicroservice.infrastructure.repositories;

import org.afp.dddmicroservice.infrastructure.entities.ResourceEntity;
import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceMySQLJPARepository extends ReactiveCrudRepository<ResourceEntity, UUID> {}
