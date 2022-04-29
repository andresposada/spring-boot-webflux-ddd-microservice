package org.afp.dddmicroservice.core.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServiceMetricsTagKey {

  REQUEST("request"),
  RESPONSE("response");

  private final String value;

}
