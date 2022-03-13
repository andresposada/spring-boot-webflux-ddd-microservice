package org.afp.dddmicroservice.infrastructure.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("resources")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class ResourceEntity extends GeneralEntity {
  @Column("property_one")
  String propertyOne;

  @Column("property_one")
  String propertyTwo;
}
