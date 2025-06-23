package org.springframework.samples.petclinic.rest.config.springdoc;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

  @Bean
  public GroupedOpenApi capOpenApi() {
    return GroupedOpenApi.builder()
        .group("apis")
        .pathsToMatch("/api/**")
        .addOpenApiCustomizer(new OpenApiDocCustomizer())
        .build();
  }
}
