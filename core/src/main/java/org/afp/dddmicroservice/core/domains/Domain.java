package org.afp.dddmicroservice.core.domains;

import java.time.Instant;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Domain {
  UUID id = UUID.randomUUID();
  Instant createdAt = Instant.now();
  Instant updatedAt = Instant.now();
}
