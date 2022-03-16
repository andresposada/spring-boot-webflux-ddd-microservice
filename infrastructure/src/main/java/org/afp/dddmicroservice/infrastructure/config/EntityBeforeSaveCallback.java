package org.afp.dddmicroservice.infrastructure.config;

import org.springframework.stereotype.Component;

@Component
public class EntityBeforeSaveCallback  {
  /*
  implements BeforeSaveCallback<GeneralEntity>
  @Override
  public Publisher<GeneralEntity> onBeforeSave(GeneralEntity entity, OutboundRow row, SqlIdentifier table) {
    row.append("id", Parameter.from(UUID.randomUUID()));
    return Mono.just(entity);
  }
  */

}
