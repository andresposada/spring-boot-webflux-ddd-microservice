package org.afp.dddmicroservice.application.model.mappers;

import org.afp.dddmicroservice.application.model.requests.CreateResourceRequest;
import org.afp.dddmicroservice.application.model.responses.resource.ResourceResponse;
import org.afp.dddmicroservice.core.domains.resource.Resource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResourceRequestResponseMapper {
  ResourceResponse resourceToResourceResponse(Resource resource);

  Resource resourceResponseToResource(ResourceResponse resourceResponse);

  Resource createResourceRequestToResource(CreateResourceRequest createResourceRequest);
}
