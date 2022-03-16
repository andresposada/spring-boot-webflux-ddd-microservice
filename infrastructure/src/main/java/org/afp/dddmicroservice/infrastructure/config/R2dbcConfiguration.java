package org.afp.dddmicroservice.infrastructure.config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class R2dbcConfiguration  {
/*
  extends AbstractR2dbcConfiguration
  final R2dbcProperties r2dbcProperties;

  @Override
  public ConnectionFactory connectionFactory() {
    return ConnectionFactories.get(r2dbcProperties.getUrl());
  }

  @Override
  protected List<Object> getCustomConverters() {
    return List.of(new UUIDToStringConverter());
  }

  static class UUIDToStringConverter implements Converter<UUID, String> {

    @Override
    public String convert(UUID source) {
      return source.toString();
    }

  }
*/
}
