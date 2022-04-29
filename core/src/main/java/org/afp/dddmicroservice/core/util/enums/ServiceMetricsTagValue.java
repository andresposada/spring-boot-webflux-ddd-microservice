package org.afp.dddmicroservice.core.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum to tag metric values sending to Prometheus. The tags should use according to this rules
 * <li>SUCCESS<li/> Use it when you measure a success event in the application
 * <li>EXCEPTION<li/> Use it when HTTP response is something other than 2XX.
 * <li>FAILURE<li/> Use it when HTTP response is 2XX but the response carries an undesirable outcome such as error
 */
@AllArgsConstructor
@Getter
public enum ServiceMetricsTagValue {

  SUCCESS("success"),
  EXCEPTION("exception"),
  FAILURE("failure");

  private final String value;

}
