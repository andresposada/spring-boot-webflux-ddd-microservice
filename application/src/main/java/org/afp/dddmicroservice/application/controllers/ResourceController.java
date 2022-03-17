package org.afp.dddmicroservice.application.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.afp.dddmicroservice.application.model.mappers.ResourceRequestResponseMapper;
import org.afp.dddmicroservice.application.model.requests.CreateResourceRequest;
import org.afp.dddmicroservice.application.model.responses.ErrorResponse;
import org.afp.dddmicroservice.application.model.responses.resource.ResourceResponse;
import org.afp.dddmicroservice.core.ports.incoming.ResourceUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/resources")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResourceController {
  final ResourceUseCase resourceUseCase;
  final ResourceRequestResponseMapper mapper;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @Operation(summary = "Gets all available resources from data storage")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "When a resource list have been found",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ResourceResponse.class))),
        @ApiResponse(
            responseCode = "404",
            description = "When no resources were not found",
            content = @Content)
      })
  public Flux<ResourceResponse> getResources() {
    return resourceUseCase.getFluxResource().map(mapper::resourceToResourceResponse);
  }

  @GetMapping("async")
  public Flux<ResourceResponse> getResourcesAsync() {
    return resourceUseCase.getResources().map(mapper::resourceToResourceResponse);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Saves a resource into the data storage")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "201",
            description = "When a resource is created correctly",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ResourceResponse.class))),
        @ApiResponse(
            responseCode = "412",
            description = "When mandatory fields are not populated correctly",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)))
      })
  public Mono<ResourceResponse> saveResource(
      @RequestBody @Valid CreateResourceRequest createResourceRequest) {
    return resourceUseCase
        .saveResource(mapper.createResourceRequestToResource(createResourceRequest))
        .map(mapper::resourceToResourceResponse);
  }
}
