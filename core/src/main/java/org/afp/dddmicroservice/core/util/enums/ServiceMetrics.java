package org.afp.dddmicroservice.core.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServiceMetrics {

  SAVED_RESOURCES("ddd-microservice_saved_resources_count");

  private final String metricName;
}
