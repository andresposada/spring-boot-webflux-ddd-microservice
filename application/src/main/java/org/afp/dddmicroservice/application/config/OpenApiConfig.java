package org.afp.dddmicroservice.application.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().info(getInfo()).externalDocs(getExternalDocs());
  }

  private ExternalDocumentation getExternalDocs() {
    return new ExternalDocumentation()
        .description("Github")
        .url("https://github.com/viafoura/microservices-template");
  }

  private Info getInfo() {
    return new Info()
        .title("Domain driven design service")
        .description("Microservice ddd structure to serve as a template for all Viafoura projects")
        .version("0.0.1");
  }
}
