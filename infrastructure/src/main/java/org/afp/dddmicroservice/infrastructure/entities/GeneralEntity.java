package org.afp.dddmicroservice.infrastructure.entities;

import java.time.Instant;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public abstract class GeneralEntity {

  @Id
  @Column("id")
  UUID id = UUID.randomUUID();

  @Column("created_at")
  Instant createdAt = Instant.now();

  @Column("created_at")
  Instant updatedAt = Instant.now();

  /*
  @PreUpdate
  public void preUpdate() {
    setUpdatedAt(Instant.now());
  }
  */

}
