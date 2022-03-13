package org.afp.dddmicroservice.application.model.responses.resource;

import org.afp.dddmicroservice.application.model.responses.DomainResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Object containing resource attributes")
public class ResourceResponse extends DomainResponse {
  @Schema(description = "Value for property one")
  String propertyOne;

  @Schema(description = "Value for property two")
  String propertyTwo;
}
