package org.afp.dddmicroservice.infrastructure.repositories;

import java.util.UUID;
import org.afp.dddmicroservice.infrastructure.entities.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceMySQLJPARepository extends JpaRepository<ResourceEntity, UUID> {}
