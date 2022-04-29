package org.afp.dddmicroservice.application.config;

import org.afp.dddmicroservice.core.ports.outgoing.MetricsPort;
import org.afp.dddmicroservice.core.ports.outgoing.ResourceRepositoryPort;
import org.afp.dddmicroservice.core.services.ResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
  @Bean
  public ResourceService resourceService(ResourceRepositoryPort resourceRepositoryPort, MetricsPort metricsPort) {
    return new ResourceService(resourceRepositoryPort, metricsPort);
  }
}
