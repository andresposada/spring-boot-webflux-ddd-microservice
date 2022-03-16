package org.afp.dddmicroservice.infrastructure.repositories;

import org.afp.dddmicroservice.infrastructure.entities.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResourceMySQLJPARepository extends JpaRepository<ResourceEntity, UUID> {}
