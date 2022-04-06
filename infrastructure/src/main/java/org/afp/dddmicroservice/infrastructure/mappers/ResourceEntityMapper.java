package org.afp.dddmicroservice.infrastructure.mappers;

import org.afp.dddmicroservice.core.domains.resource.Resource;
import org.afp.dddmicroservice.infrastructure.entities.ResourceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResourceEntityMapper {
  Resource resourceEntityToResource(ResourceEntity resourceEntity);

  ResourceEntity resourceToResourceEntity(Resource resource);
}
